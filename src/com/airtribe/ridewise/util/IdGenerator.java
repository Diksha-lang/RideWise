package com.airtribe.ridewise.util;

public class IdGenerator {

    private static int riderId = 1;
    private static int driverId = 1;
    private static int rideId = 1;

    public static int generateRiderId() {
        return riderId++;
    }

    public static int generateDriverId() {
        return driverId++;
    }

    public static int generateRideId() {
        return rideId++;
    }
}