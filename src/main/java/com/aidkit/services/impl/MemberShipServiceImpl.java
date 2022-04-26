package com.aidkit.services.impl;

import com.aidkit.dao.IMemberShipDAO;
import com.aidkit.models.Aidkit;
import com.aidkit.models.MemberShip;
import com.aidkit.services.IMemberShipService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberShipServiceImpl implements IMemberShipService {
    @Autowired
    IMemberShipDAO memberShipDAO;
    public MemberShipServiceImpl(IMemberShipDAO memberShipDAO) {
        this.memberShipDAO = memberShipDAO;
    }

    @Override
    public void saveMemberShip(MemberShip memberShip) {
        memberShipDAO.saveMemberShip(memberShip);
    }

    @Override
    public List<Aidkit> getAidKitIdbyUserId(int userId) {
        return memberShipDAO.getAidKitIdbyUserId(userId);
    }
}
