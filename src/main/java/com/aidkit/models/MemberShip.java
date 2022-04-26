package com.aidkit.models;

import javax.persistence.*;

@Entity
@Table(name = "tMemberShip")
@Embeddable
public class MemberShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberShipId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User userId;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "aidkitId", referencedColumnName = "aidkitId")
    private Aidkit aidkitId;

    public int getMemberShipId() {
        return memberShipId;
    }

    public void setMemberShipId(int memberShipId) {
        this.memberShipId = memberShipId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Aidkit getAidkitId() {
        return aidkitId;
    }

    public void setAidkitId(Aidkit aidkitId) {
        this.aidkitId = aidkitId;
    }

    @Override
    public String toString() {
        return "MemberShip{" +
                "memberShipId=" + memberShipId +
                ", userId=" + userId +
                '}';
    }
}
