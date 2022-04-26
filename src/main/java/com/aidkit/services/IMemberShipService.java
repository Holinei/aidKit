package com.aidkit.services;

import com.aidkit.models.Aidkit;
import com.aidkit.models.MemberShip;

import java.util.List;

public interface IMemberShipService {
    public void saveMemberShip(MemberShip memberShip);
    public List<Aidkit> getAidKitIdbyUserId(int userId);
}
