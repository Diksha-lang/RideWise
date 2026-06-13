package com.airtribe.ridewise.model;

public class Driver {

    private int id;
    private String name;
    private String currentLocation;
    private boolean available;
    private int ridesCompleted;

    public Driver(int id, String name, String currentLocation) {
        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = true;
        this.ridesCompleted = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getRidesCompleted() {
        return ridesCompleted;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void incrementRideCount() {
        ridesCompleted++;
    }

    @Override
    public String toString() {
        return "Driver ID: " + id +
                ", Name: " + name +
                ", Location: " + currentLocation +
                ", Available: " + available;
    }
}