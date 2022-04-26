package com.aidkit.services;

import com.aidkit.models.AidKitMedicine;
import com.aidkit.models.Aidkit;
import com.aidkit.models.Medicine;
import com.aidkit.models.Package;

import java.util.List;

public interface IAidKitMedicineService {
    List<AidKitMedicine> getAidMedicineList(int aidkitId);
    void addMedicineToAidKit(AidKitMedicine aidKitMedicine, Medicine medicine, Package packageId, Aidkit aidkit);
    void removeMedicine(AidKitMedicine aidKitMedicine, int medicineId);
}
