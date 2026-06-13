package com.airtribe.ridewise.service;

import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.FareReceipt;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.RideStatus;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.strategy.FareStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;
import com.airtribe.ridewise.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class RideService {

    private List<Ride> rides = new ArrayList<>();

    private RideMatchingStrategy rideMatchingStrategy;
    private FareStrategy fareStrategy;

    public RideService(
            RideMatchingStrategy rideMatchingStrategy,
            FareStrategy fareStrategy) {

        this.rideMatchingStrategy = rideMatchingStrategy;
        this.fareStrategy = fareStrategy;
    }

    public Ride requestRide(
            Rider rider,
            List<Driver> drivers,
            double distance) {

        Driver driver =
                rideMatchingStrategy.findDriver(rider, drivers);

        if (driver == null) {
            throw new NoDriverAvailableException(
                    "No Driver Available");
        }

        Ride ride = new Ride(
                IdGenerator.generateRideId(),
                rider,
                driver,
                distance,
                RideStatus.REQUESTED);

        ride.setStatus(RideStatus.ASSIGNED);

        driver.setAvailable(false);

        rides.add(ride);

        return ride;
    }

    public FareReceipt generateReceipt(Ride ride) {

        double fare =
                fareStrategy.calculateFare(ride);

        return new FareReceipt(
                ride.getId(),
                fare);
    }

    public void completeRide(int rideId) {

        for (Ride ride : rides) {

            if (ride.getId() == rideId) {

                ride.setStatus(
                        RideStatus.COMPLETED);

                ride.getDriver()
                        .setAvailable(true);

                ride.getDriver()
                        .incrementRideCount();

                return;
            }
        }
    }

    public void cancelRide(int rideId) {

        for (Ride ride : rides) {

            if (ride.getId() == rideId) {

                ride.setStatus(
                        RideStatus.CANCELLED);

                ride.getDriver()
                        .setAvailable(true);

                return;
            }
        }
    }

    public List<Ride> getAllRides() {
        return rides;
    }
}