package com.aidkit.dao.impl;

import com.aidkit.dao.IMemberShipDAO;
import com.aidkit.models.Aidkit;
import com.aidkit.models.MemberShip;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberShipDAOImpl implements IMemberShipDAO {
    @Autowired
    SessionFactory sessionFactory;

    public MemberShipDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void saveMemberShip(MemberShip memberShip) {
        Session session;
        Transaction tx = null;
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(memberShip);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public List<Aidkit> getAidKitIdbyUserId(int userId) {
        Session session = this.sessionFactory.openSession();
        List<Aidkit> aidkitList = (List<Aidkit>) session
                .createQuery("SELECT aidkitId FROM com.aidkit.models.MemberShip WHERE userId = '" + userId + "'")
                .list();
        session.close();
        return aidkitList;
    }

}
