package com.example.dokterrkuu.Model;

import android.provider.Telephony;

public class User {
    private String id;
    private String username;
    private String Email;
    private String imageURL;
    private String Phone;
    private String Address;


    public User(String id, String username, String imageURL, String Email, String Phone, String Address) {
        this.id = id;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
        this.username = username;
        this.imageURL = imageURL;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}


