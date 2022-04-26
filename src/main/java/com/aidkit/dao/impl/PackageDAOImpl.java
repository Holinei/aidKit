package com.aidkit.dao.impl;

import com.aidkit.dao.IPackageDAO;
import com.aidkit.models.Package;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PackageDAOImpl implements IPackageDAO {
    @Autowired
    SessionFactory sessionFactory;

    public PackageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Package getPackageById(int id) {
        Session session = this.sessionFactory.openSession();
        Package packageTo = (Package) session
                .createQuery("FROM com.aidkit.models.Package WHERE packageId = '" + id + "'")
                .uniqueResult();
        session.close();
        return packageTo;
    }
}
