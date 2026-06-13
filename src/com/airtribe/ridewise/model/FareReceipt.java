package com.airtribe.ridewise.model;

import java.time.LocalDateTime;

public class FareReceipt {

    private int rideId;
    private double amount;
    private LocalDateTime generatedAt;

    public FareReceipt(int rideId, double amount) {
        this.rideId = rideId;
        this.amount = amount;
        this.generatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Ride ID: " + rideId +
                ", Fare: ₹" + amount +
                ", Generated At: " + generatedAt;
    }
}