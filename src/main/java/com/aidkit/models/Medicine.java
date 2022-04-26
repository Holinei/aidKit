package com.aidkit.models;

import javax.persistence.*;

@Entity
@Table(name = "tMedicine")
@Embeddable
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicineId;
    private String medicineName;
    private String medicineStrength;
    private String activeSubstance;
    private String pharmaceuticalForm;
    private String symptoms;
    private String dose;

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }


    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
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



    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", medicineStrength='" + medicineStrength + '\'' +
                ", activeSubstance='" + activeSubstance + '\'' +
                ", pharmaceuticalForm='" + pharmaceuticalForm + '\'' +
                '}';
    }
}
