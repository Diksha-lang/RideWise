package com.airtribe.ridewise.model;

public class Ride {

    private int id;
    private Rider rider;
    private Driver driver;
    private double distance;
    private RideStatus status;

    public Ride(int id,
                Rider rider,
                Driver driver,
                double distance,
                RideStatus status) {

        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ride ID: " + id +
                ", Rider: " + rider.getName() +
                ", Driver: " + driver.getName() +
                ", Distance: " + distance +
                ", Status: " + status;
    }
}