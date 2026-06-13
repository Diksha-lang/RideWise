package com.airtribe.ridewise.service;

import com.airtribe.ridewise.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverService {

    private List<Driver> drivers = new ArrayList<>();

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public List<Driver> getAvailableDrivers() {

        List<Driver> available = new ArrayList<>();

        for (Driver driver : drivers) {

            if (driver.isAvailable()) {
                available.add(driver);
            }
        }

        return available;
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }
}