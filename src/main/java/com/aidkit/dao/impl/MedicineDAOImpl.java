package com.aidkit.dao.impl;

import com.aidkit.dao.IMedicineDAO;
import com.aidkit.models.Medicine;
import com.aidkit.models.Package;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicineDAOImpl implements IMedicineDAO {

    @Autowired
    SessionFactory sessionFactory;

    public MedicineDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Medicine> getMedicineListFromDB() {
        Session session = this.sessionFactory.openSession();
        List<Medicine> categoryList = (List<Medicine>) session
                .createQuery("FROM com.aidkit.models.Medicine")
                .list();
        session.close();
        return categoryList;
    }

    @Override
    public Medicine getMedicineById(int id) {
        Session session = this.sessionFactory.openSession();
        Medicine medicine = (Medicine) session
                .createQuery("FROM com.aidkit.models.Medicine WHERE medicineId = '" + id + "'")
                .uniqueResult();
        session.close();
        return medicine;
    }

    @Override
    public List<Package> getPackageListById(int id) {
        Session session = this.sessionFactory.openSession();
        List<Package> packageList2 = (List<Package>) session
                .createQuery("FROM Package WHERE medicineId = '" + id + "'")
                .list();

        session.close();
        return packageList2;
    }
}

