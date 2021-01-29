package com.aidKit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tMedicine")
public class Medicine {
    @Id
    String codeATC;
    String medicineName;
    String medicineCommonName;
    String medicineType;
    String medicineStrength;
    String activeSubstance;
    String pharmaceuticalForm;
    String medicineProcedure;
    String numberMA;
    String codeEAN;
    String medicinePackage;


    public String getCodeATC() {
        return codeATC;
    }

    public void setCodeATC(String codeATC) {
        this.codeATC = codeATC;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineCommonName() {
        return medicineCommonName;
    }

    public void setMedicineCommonName(String medicineCommonName) {
        this.medicineCommonName = medicineCommonName;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getMedicineStrength() {
        return medicineStrength;
    }

    public void setMedicineStrength(String medicineStrength) {
        this.medicineStrength = medicineStrength;
    }

    public String getActiveSubstance() {
        return activeSubstance;
    }

    public void setActiveSubstance(String activeSubstance) {
        this.activeSubstance = activeSubstance;
    }

    public String getPharmaceuticalForm() {
        return pharmaceuticalForm;
    }

    public void setPharmaceuticalForm(String pharmaceuticalForm) {
        this.pharmaceuticalForm = pharmaceuticalForm;
    }

    public String getMedicineProcedure() {
        return medicineProcedure;
    }

    public void setMedicineProcedure(String medicineProcedure) {
        this.medicineProcedure = medicineProcedure;
    }

    public String getNumberMA() {
        return numberMA;
    }

    public void setNumberMA(String numberMA) {
        this.numberMA = numberMA;
    }

    public String getCodeEAN() {
        return codeEAN;
    }

    public void setCodeEAN(String codeEAN) {
        this.codeEAN = codeEAN;
    }

    public String getMedicinePackage() {
        return medicinePackage;
    }

    public void setMedicinePackage(String medicinePackage) {
        this.medicinePackage = medicinePackage;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "codeATC='" + codeATC + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", medicineCommonName='" + medicineCommonName + '\'' +
                ", medicineType='" + medicineType + '\'' +
                ", medicineStrength='" + medicineStrength + '\'' +
                ", activeSubstance='" + activeSubstance + '\'' +
                ", pharmaceuticalForm='" + pharmaceuticalForm + '\'' +
                ", medicineProcedure='" + medicineProcedure + '\'' +
                ", numberMA='" + numberMA + '\'' +
                ", codeEAN='" + codeEAN + '\'' +
                ", medicinePackage='" + medicinePackage + '\'' +
                '}';
    }
}
