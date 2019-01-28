package com.example.juman.mucontractlist;

/**
 * Created by Juman on 1/17/2016.
 */
public class ContactInfo {


    private String name;
    private String roll;
    private String address;
    private String phone;
    private String email;


    public ContactInfo(String name, String roll, String address, String phone, String email) {
        this.name = name;
        this.roll = roll;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
