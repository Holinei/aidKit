package com.aidkit.services;

import com.aidkit.models.Aidkit;
import com.aidkit.models.MemberShip;

import java.util.List;

public interface IAidKitService {
    public void saveAidKit(Aidkit aidkit);
    List<MemberShip> getMemberShipList(int userId);
    Aidkit getAidkitById(int id);
}
