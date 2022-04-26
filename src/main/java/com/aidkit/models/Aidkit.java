package com.aidkit.models;

import javax.persistence.*;

@Entity
@Table(name = "tAidkit")
@Embeddable
public class Aidkit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aidkitId;
    private String nameAidKit;

    public int getAidkitId() {
        return aidkitId;
    }

    public void setAidkitId(int aidkitId) {
        this.aidkitId = aidkitId;
    }

    public String getNameAidKit() {
        return nameAidKit;
    }

    public void setNameAidKit(String nameAidKit) {
        this.nameAidKit = nameAidKit;
    }

    @Override
    public String toString() {
        return "Aidkit{" +
                "aidkitId=" + aidkitId +
                '}';
    }
}

