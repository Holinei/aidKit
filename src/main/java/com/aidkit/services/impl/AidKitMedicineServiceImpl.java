package com.aidkit.services.impl;

import com.aidkit.dao.IAidKitMedicineDAO;
import com.aidkit.models.AidKitMedicine;
import com.aidkit.models.Aidkit;
import com.aidkit.models.Medicine;
import com.aidkit.models.Package;
import com.aidkit.services.IAidKitMedicineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AidKitMedicineServiceImpl implements IAidKitMedicineService {
    @Autowired
    IAidKitMedicineDAO aidKitMedicineDAO;
    public AidKitMedicineServiceImpl(IAidKitMedicineDAO aidKitMedicineDAO) {
        this.aidKitMedicineDAO = aidKitMedicineDAO;
    }
    @Override
    public List<AidKitMedicine> getAidMedicineList(int aidkitId) {
        return aidKitMedicineDAO.getAidMedicineList(aidkitId);
    }

    @Override
    public void addMedicineToAidKit(AidKitMedicine aidKitMedicine, Medicine medicine, Package packageId, Aidkit aidkit) {
        aidKitMedicineDAO.addMedicineToAidKit(aidKitMedicine, medicine, packageId, aidkit);
    }

    @Override
    public void removeMedicine(int aidKitMedicine) {
        aidKitMedicineDAO.removeMedicine(aidKitMedicine);
    }
    
    @Override
    public void useMedicine(int aidKitMedicineId, int newAmount) {
        aidKitMedicineDAO.useMedicine(aidKitMedicineId, newAmount);
    }
    @Override
    public AidKitMedicine getAidKitMedicine(int aidKitMedicineId) {
        return aidKitMedicineDAO.getAidMedicine(aidKitMedicineId);
    }
}
