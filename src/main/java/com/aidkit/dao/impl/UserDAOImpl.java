package com.aidkit.dao.impl;

import com.aidkit.dao.IUserDAO;
import com.aidkit.models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        Session session;
        Transaction tx = null;
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(user);
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
    public User getUserByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        User user = (User) session
                .createQuery("FROM com.aidkit.models.User WHERE email = '" + email + "'")
                .uniqueResult();
        session.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session;
        Transaction tx = null;
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.update(user);
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
    public void deleteUser(User user) {
        Session session;
        Transaction tx = null;
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.delete(user);
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
    public User getUserById(int id) {
        Session session = this.sessionFactory.openSession();
        User user = (User) session
                .createQuery("FROM com.aidkit.models.User WHERE id = '" + id + "'")
                .uniqueResult();
        session.close();
        return user;
    }
}
