package com.example.SimpleJAXRS.entities;

public class Organization {

    private int id;
    private String name;
    private String address;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organization (int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
