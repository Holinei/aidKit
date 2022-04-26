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


}
