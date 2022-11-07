package com.aidkit.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tHistoryAidkit")
@Embeddable
public class HistoryAidkit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;
    @ManyToOne
    @JoinColumn(name = "aidkitId", referencedColumnName = "aidkitId")
    private Aidkit aidkitId;
    private Date changedDate;
    private int amount;
    private int packageAmount;
    private String typeOfDisposal;
    private int userId;

    public int getHistoryId() {
        return this.historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public Aidkit getAidkitId() {
        return this.aidkitId;
    }

    public void setAidkitId(Aidkit aidkitId) {
        this.aidkitId = aidkitId;
    }

    public Date getChangedDate() {
        return this.changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPackageAmount() {
        return this.packageAmount;
    }

    public void setPackageAmount(int packageAmount) {
        this.packageAmount = packageAmount;
    }

    public String getTypeOfDisposal() {
        return this.typeOfDisposal;
    }

    public void setTypeOfDisposal(String typeOfDisposal) {
        this.typeOfDisposal = typeOfDisposal;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
