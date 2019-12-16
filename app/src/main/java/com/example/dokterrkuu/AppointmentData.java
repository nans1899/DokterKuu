package com.example.dokterrkuu;


import java.util.Date;

public class AppointmentData {

    private String aName;
    private Date aDate;
    private String aDName;
    private String aDHospital;

    public AppointmentData() {
    }

    public AppointmentData(String aName, Date aDate, String aDName, String aDHospital) {
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

    public String getaDName() {
        return aDName;
    }

    public void setaDName(String aDName) {
        this.aDName = aDName;
    }

    public String getaDHospital() {
        return aDHospital;
    }

    public void setaDHospital(String aDHospital) {
        this.aDHospital = aDHospital;
    }
}
