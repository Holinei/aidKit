package com.aidkit.services;

import com.aidkit.models.Medicine;
import com.aidkit.models.Package;

import java.util.List;

public interface IMedicineService {
    List<Medicine> getMedicineListFromDB();
    Medicine getMedicineById(int id);
    List<Package> getpackagebyId(int id);
}
