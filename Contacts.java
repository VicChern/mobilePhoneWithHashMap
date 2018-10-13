package com.company;

public class Contacts {
    private  String name;
    private  String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + ":" + phoneNumber;
    }
}
