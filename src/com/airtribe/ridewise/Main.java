package com.airtribe.ridewise;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.FareReceipt;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideService;
import com.airtribe.ridewise.service.RiderService;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.util.IdGenerator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RiderService riderService =
                new RiderService();

        DriverService driverService =
                new DriverService();

        RideService rideService =
                new RideService(
                        new NearestDriverStrategy(),
                        new DefaultFareStrategy());

        while (true) {

            try {

                System.out.println("\n===== RideWise =====");

                System.out.println("1. Add Rider");
                System.out.println("2. Add Driver");
                System.out.println("3. View Available Drivers");
                System.out.println("4. Request Ride");
                System.out.println("5. Complete Ride");
                System.out.println("6. Cancel Ride");
                System.out.println("7. View Rides");
                System.out.println("8. Exit");

                System.out.print("Choose: ");

                int choice =
                        Integer.parseInt(
                                scanner.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print("Name: ");
                        String riderName =
                                scanner.nextLine();

                        System.out.print("Location: ");
                        String riderLocation =
                                scanner.nextLine();

                        Rider rider =
                                new Rider(
                                        IdGenerator.generateRiderId(),
                                        riderName,
                                        riderLocation);

                        riderService.registerRider(rider);

                        System.out.println(
                                "Rider Added");

                        break;

                    case 2:

                        System.out.print("Name: ");
                        String driverName =
                                scanner.nextLine();

                        System.out.print("Location: ");
                        String driverLocation =
                                scanner.nextLine();

                        Driver driver =
                                new Driver(
                                        IdGenerator.generateDriverId(),
                                        driverName,
                                        driverLocation);

                        driverService.registerDriver(driver);

                        System.out.println(
                                "Driver Added");

                        break;

                    case 3:

                        for (Driver d :
                                driverService.getAvailableDrivers()) {

                            System.out.println(d);
                        }

                        break;

                    case 4:

                        System.out.print("Rider ID: ");

                        int riderId =
                                Integer.parseInt(
                                        scanner.nextLine());

                        System.out.print("Distance: ");

                        double distance =
                                Double.parseDouble(
                                        scanner.nextLine());

                        Rider foundRider =
                                riderService.getRiderById(riderId);

                        if (foundRider == null) {

                            System.out.println(
                                    "Rider Not Found");

                            break;
                        }

                        Ride ride =
                                rideService.requestRide(
                                        foundRider,
                                        driverService.getAllDrivers(),
                                        distance);

                        System.out.println(
                                "Ride Assigned");

                        FareReceipt receipt =
                                rideService.generateReceipt(
                                        ride);

                        System.out.println(
                                receipt);

                        break;

                    case 5:

                        System.out.print(
                                "Ride ID: ");

                        int rideId =
                                Integer.parseInt(
                                        scanner.nextLine());

                        rideService.completeRide(
                                rideId);

                        System.out.println(
                                "Ride Completed");

                        break;

                    case 6:

                        System.out.print(
                                "Ride ID: ");

                        int cancelRideId =
                                Integer.parseInt(
                                        scanner.nextLine());

                        rideService.cancelRide(
                                cancelRideId);

                        System.out.println(
                                "Ride Cancelled");

                        break;

                    case 7:

                        for (Ride r :
                                rideService.getAllRides()) {

                            System.out.println(r);
                        }

                        break;

                    case 8:

                        System.out.println(
                                "Thank You");

                        return;

                    default:

                        System.out.println(
                                "Invalid Choice");
                }

            } catch (Exception e) {

                System.out.println(
                        "Invalid Input. Please Try Again.");
            }
        }
    }
}