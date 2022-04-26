package com.aidkit.models;

import javax.persistence.*;

@Entity
@Table(name = "tPackage")
@Embeddable
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;



    private String codeEAN;
    private String packageContent;
    private String pathToDescription;
    @ManyToOne
    @JoinColumn(name = "medicineId", referencedColumnName = "medicineId")
    private Medicine medicineId;
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    public String getCodeEAN() {
        return codeEAN;
    }

    public void setCodeEAN(String codeEAN) {
        this.codeEAN = codeEAN;
    }

    public String getPackageContent() {
        return packageContent;
    }

    public void setPackageContent(String packageContent) {
        this.packageContent = packageContent;
    }

    public String getPathToDescription() {
        return pathToDescription;
    }

    public void setPathToDescription(String pathToDescription) {
        this.pathToDescription = pathToDescription;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageId=" + packageId +
                ", codeEAN='" + codeEAN + '\'' +
                ", packageContent='" + packageContent + '\'' +
                '}';
    }
}
