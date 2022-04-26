package com.aidkit.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tAidKitMedicine")
@Embeddable
public class AidKitMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aidKitMedicineId;
    @ManyToOne
    @JoinColumn(name = "aidkitId", referencedColumnName = "aidkitId")
    private Aidkit aidkitId;

    @ManyToOne
    @JoinColumn(name = "medicineId", referencedColumnName = "medicineId")
    private Medicine medicineId;

    @OneToOne
    @JoinColumn(name = "packageId", referencedColumnName = "packageId")
    private Package packageId;
    private int amountOfMedicine;
    private Date expirationDate;

    public int getAidKitMedicineId() {
        return aidKitMedicineId;
    }

    public void setAidKitMedicineId(int aidKitMedicineId) {
        this.aidKitMedicineId = aidKitMedicineId;
    }

    public Aidkit getAidkitId() {
        return aidkitId;
    }

    public void setAidkitId(Aidkit aidkitId) {
        this.aidkitId = aidkitId;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    public int getAmountOfMedicine() {
        return amountOfMedicine;
    }

    public void setAmountOfMedicine(int amountOfMedicine) {
        this.amountOfMedicine = amountOfMedicine;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Package getPackageId() {
        return packageId;
    }

    public void setPackageId(Package packageId) {
        this.packageId = packageId;
    }

    @Override
    public String toString() {
        return "AidKitMedicine{" +
                "aidKitMedicineId=" + aidKitMedicineId +
                ", aidkitId=" + aidkitId +
                ", medicineId=" + medicineId +
                ", amountOfMedicine=" + amountOfMedicine +
                ", expirationDate=" + expirationDate +
                '}';
    }

}
