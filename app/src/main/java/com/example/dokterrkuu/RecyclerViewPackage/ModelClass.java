package com.example.dokterrkuu.RecyclerViewPackage;

import java.sql.Date;

public class ModelClass {

    String Name;
    String date;
    String disease;
    String docName;
    String hospital;
    String keluhan;

    public ModelClass() {
    }

    public ModelClass(String name, String date, String disease, String docName, String hospital, String keluhan) {
        Name = name;
        this.date = date;
        this.disease = disease;
        this.docName = docName;
        this.hospital = hospital;
        this.keluhan = keluhan;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}
