package com.example.dokterrkuu;

import androidx.annotation.NonNull;

public class DocData {
    private String dName;
    private String dEmail;
    private String dPhone;
    private String dHospital;

    public DocData() {
    }

    public DocData(String dName, String dEmail, String dPhone, String dHospital) {
        this.dName = dName;
        this.dEmail = dEmail;
        this.dPhone = dPhone;
        this.dHospital = dHospital;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdEmail() {
        return dEmail;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail;
    }

    public String getdPhone() {
        return dPhone;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone;
    }

    public String getdHospital() {
        return dHospital;
    }

    public void setdHospital(String dHospital) {
        this.dHospital = dHospital;
    }

    @NonNull
    @Override
    public String toString() {
        return dName;
    }

}
