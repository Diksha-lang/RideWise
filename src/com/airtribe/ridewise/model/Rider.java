package com.airtribe.ridewise.model;

public class Rider {

    private int id;
    private String name;
    private String location;

    public Rider(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Rider ID: " + id +
                ", Name: " + name +
                ", Location: " + location;
    }
}