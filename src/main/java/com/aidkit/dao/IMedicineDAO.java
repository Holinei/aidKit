package com.aidkit.dao;

import com.aidkit.models.Medicine;
import com.aidkit.models.Package;
import java.util.List;

public interface IMedicineDAO {

    List<Medicine> getMedicineListFromDB();
    Medicine getMedicineById(int id);
    List<Package> getpackagebyId(int id);
}
