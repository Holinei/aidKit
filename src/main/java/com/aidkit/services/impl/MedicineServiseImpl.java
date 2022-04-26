package com.aidkit.services.impl;

import com.aidkit.dao.IMedicineDAO;
import com.aidkit.models.Medicine;
import com.aidkit.models.Package;
import com.aidkit.services.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicineServiseImpl implements IMedicineService {
    @Autowired
    IMedicineDAO medicineDAO;

    public MedicineServiseImpl(IMedicineDAO medicineDAO) {
        this.medicineDAO = medicineDAO;
    }

    @Override
    public List<Medicine> getMedicineListFromDB() {
        return medicineDAO.getMedicineListFromDB();
    }

    @Override
    public Medicine getMedicineById(int id) {
        return this.medicineDAO.getMedicineById(id);
    }

    @Override
    public List<Package> getpackagebyId(int id) {
        return this.medicineDAO.getpackagebyId(id);
    }
}
