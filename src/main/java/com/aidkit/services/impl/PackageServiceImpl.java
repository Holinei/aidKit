package com.aidkit.services.impl;

import com.aidkit.dao.IPackageDAO;
import com.aidkit.models.Package;
import com.aidkit.services.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;

public class PackageServiceImpl implements IPackageService {
    @Autowired
    IPackageDAO packageDAO;
    public PackageServiceImpl(IPackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }


    @Override
    public Package getPackageById(int id) {
        return packageDAO.getPackageById(id);
    }

}
