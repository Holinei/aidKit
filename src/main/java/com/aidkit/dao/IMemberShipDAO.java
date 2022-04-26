package com.aidkit.dao;

import com.aidkit.models.Aidkit;
import com.aidkit.models.MemberShip;

import java.util.List;

public interface IMemberShipDAO {
    public void saveMemberShip(MemberShip memberShip);
    public List<Aidkit> getAidKitIdbyUserId(int userId);
}
