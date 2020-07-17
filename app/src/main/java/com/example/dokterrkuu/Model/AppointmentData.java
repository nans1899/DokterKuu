package com.example.dokterrkuu.Model;


import java.util.Date;

public class AppointmentData {

    private String id;
    private String Username;
    private String Date;
    private String Doctor;
    private String Hospital;
    private String Disease;

    public AppointmentData() {
    }

    public AppointmentData(String id, String Username, String Date, String Doctor, String Hospital, String Disease) {
        this.id = id;
        this.Username = Username;
        this.Date = Date;
        this.Doctor = Doctor;
        this.Hospital = Hospital;
        this.Disease = Disease;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String Disease) {
        this.Disease = Disease;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String Hospital) {
        this.Hospital = Hospital;
    }
}
