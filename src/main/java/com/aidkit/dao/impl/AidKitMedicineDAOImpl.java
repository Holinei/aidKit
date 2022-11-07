package com.aidkit.dao.impl;

import com.aidkit.dao.IAidKitMedicineDAO;
import com.aidkit.models.AidKitMedicine;
import com.aidkit.models.Aidkit;
import com.aidkit.models.Medicine;
import com.aidkit.models.Package;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AidKitMedicineDAOImpl implements IAidKitMedicineDAO {
    @Autowired
    SessionFactory sessionFactory;

    public AidKitMedicineDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AidKitMedicine> getAidMedicineList(int aidkitId) {
        Session session = this.sessionFactory.openSession();
        List<AidKitMedicine> aidList = (List<AidKitMedicine>) session
                .createQuery("SELECT a FROM com.aidkit.models.AidKitMedicine a INNER JOIN a.medicineId WHERE a.aidkitId = '"+ aidkitId +"'")
                .list();
        
        session.close();
        return aidList;
    }

    @Override
    public void addMedicineToAidKit(AidKitMedicine aidKitMedicine, Medicine medicine, Package packageId,
            Aidkit aidkit) {
        Session session;
        Transaction tx = null;
        try {
            aidKitMedicine.setMedicineId(medicine);
            aidKitMedicine.setPackageId(packageId);
            aidKitMedicine.setAmountOfMedicine(aidKitMedicine.getAmountOfMedicine());
            aidKitMedicine.setExpirationDate(aidKitMedicine.getExpirationDate());
            aidKitMedicine.setAidkitId(aidkit);

            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(aidKitMedicine);
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
    public void removeMedicine(int aidKitMedicineId) {
        Session session;
        Transaction tx = null;
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            AidKitMedicine aidKitMedicine = (AidKitMedicine) session
                    .createQuery(
                            "FROM com.aidkit.models.AidKitMedicine WHERE aidKitMedicineId = '" + aidKitMedicineId + "'")
                    .uniqueResult();
            session.delete(aidKitMedicine);
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
    public void useMedicine(int aidKitMedicineId, int newAmount) {
        Session session;
        Transaction tx = null;
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            AidKitMedicine aidKitMedicine = (AidKitMedicine) session
                    .createQuery(
                            "FROM com.aidkit.models.AidKitMedicine WHERE aidKitMedicineId = '" + aidKitMedicineId + "'")
                    .uniqueResult();
            aidKitMedicine.setAmountOfMedicine(newAmount);
            session.update(aidKitMedicine);
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
    public AidKitMedicine getAidMedicine(int aidKitMedicineId) {

            Session session = this.sessionFactory.openSession();
            AidKitMedicine aidKitmedicineAmont = (AidKitMedicine) session
                    .createQuery(
                            "FROM com.aidkit.models.AidKitMedicine WHERE aidKitMedicineId = '" + aidKitMedicineId + "'")
                    .uniqueResult();

            session.close();

        return aidKitmedicineAmont;
    }

}
