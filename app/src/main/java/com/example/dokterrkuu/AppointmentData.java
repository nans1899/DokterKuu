package com.example.dokterrkuu;

import android.widget.Spinner;

import java.util.Date;

public class AppointmentData {

    private String aName;
    private Date aDate;
    private Spinner aDName;
    private Spinner aDHospital;

    public AppointmentData() {
    }

    public AppointmentData(String aName, Date aDate, Spinner aDName, Spinner aDHospital) {
        this.aName = aName;
        this.aDate = aDate;
        this.aDName = aDName;
        this.aDHospital = aDHospital;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public Spinner getaDName() {
        return aDName;
    }

    public void setaDName(Spinner aDName) {
        this.aDName = aDName;
    }

    public Spinner getaDHospital() {
        return aDHospital;
    }

    public void setaDHospital(Spinner aDHospital) {
        this.aDHospital = aDHospital;
    }
}
