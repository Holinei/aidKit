package com.aidkit.dao.impl;

import com.aidkit.dao.IAidKitDAO;
import com.aidkit.models.Aidkit;
import com.aidkit.models.MemberShip;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AidKitDAOImpl implements IAidKitDAO {
    @Autowired
    SessionFactory sessionFactory;
    public AidKitDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveAidKit(Aidkit aidkit) {
        Session session;
        Transaction tx = null;
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(aidkit);
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
    public List<MemberShip> getMemberShipList(int userId) {
        Session session = this.sessionFactory.openSession();
        List<MemberShip> memberShipList = (List<MemberShip>) session
                .createQuery("FROM com.aidkit.models.MemberShip WHERE userId = '" + userId + "'")
                .list();

        session.close();
        return memberShipList;
    }

    @Override
    public Aidkit getAidkitById(int id) {
        Session session = this.sessionFactory.openSession();
        Aidkit aidkit = (Aidkit) session
                .createQuery("FROM com.aidkit.models.Aidkit WHERE aidkitId = '" + id + "'")
                .uniqueResult();
        session.close();
        return aidkit;
    }
}
