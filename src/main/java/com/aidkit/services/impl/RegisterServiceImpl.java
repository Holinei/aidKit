package com.aidkit.services.impl;

import com.aidkit.dao.IUserDAO;
import com.aidkit.models.User;
import com.aidkit.services.IRegisterService;


public class RegisterServiceImpl implements IRegisterService {
    IUserDAO userDAO;

    public RegisterServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean checkUser(User user) {
        User userFromDb = this.userDAO.getUserByEmail(user.getEmail());
        if (userFromDb == null) {
            return true;
        }
        return false;
    }
}
