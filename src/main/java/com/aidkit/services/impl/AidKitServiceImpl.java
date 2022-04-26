package com.aidkit.services.impl;

import com.aidkit.dao.IAidKitDAO;
import com.aidkit.models.Aidkit;
import com.aidkit.models.MemberShip;
import com.aidkit.services.IAidKitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AidKitServiceImpl implements IAidKitService {
    @Autowired
    IAidKitDAO aidKitDAO;
    public AidKitServiceImpl(IAidKitDAO aidKitDAO) {
        this.aidKitDAO = aidKitDAO;
    }

    @Override
    public void saveAidKit(Aidkit aidkit) {
        aidKitDAO.saveAidKit(aidkit);
    }

    @Override
    public List<MemberShip> getMemberShipList(int userId) {
        return aidKitDAO.getMemberShipList(userId);
    }

    @Override
    public Aidkit getAidkitById(int id) {
        return aidKitDAO.getAidkitById(id);
    }
}
