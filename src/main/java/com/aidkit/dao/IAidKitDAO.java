package com.aidkit.dao;

import com.aidkit.models.Aidkit;
import com.aidkit.models.MemberShip;

import java.util.List;

public interface IAidKitDAO {
    public void saveAidKit(Aidkit aidkit);
    List<MemberShip> getMemberShipList(int userId);
    Aidkit getAidkitById(int id);
}
