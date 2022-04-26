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
                .createQuery("FROM com.aidkit.models.AidKitMedicine WHERE aidkitId = '" + aidkitId + "'")
                .list();

        session.close();
        return aidList;
    }

    @Override
    public void addMedicineToAidKit(AidKitMedicine aidKitMedicine, Medicine medicine, Package packageId, Aidkit aidkit) {
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
    public void removeMedicine(AidKitMedicine aidKitMedicine, int medicineId) {

    }
}
