package com.airtribe.ridewise.service;

import com.airtribe.ridewise.model.Rider;

import java.util.ArrayList;
import java.util.List;

public class RiderService {

    private List<Rider> riders = new ArrayList<>();

    public void registerRider(Rider rider) {
        riders.add(rider);
    }

    public Rider getRiderById(int id) {

        for (Rider rider : riders) {

            if (rider.getId() == id) {
                return rider;
            }
        }

        return null;
    }

    public List<Rider> getAllRiders() {
        return riders;
    }
}