package com.aidKit.services.impl;

import com.aidKit.dao.IUserDAO;
import com.aidKit.model.User;
import com.aidKit.services.IUserService;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void registerUser(User user) {
        User userFromDb = this.userDAO.getUserByEmail(user.getEmail());
        if (userFromDb == null) {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            this.userDAO.saveUser(user);
        }
    }


    @Override
    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }



    @Override
    public User getUserByEmail(String email) {
        return this.userDAO.getUserByEmail(email);
    }


}
