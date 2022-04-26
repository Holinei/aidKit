package com.aidkit.services.impl;

import com.aidkit.dao.IUserDAO;
import com.aidkit.models.User;
import com.aidkit.services.IUserService;
import org.apache.commons.codec.digest.DigestUtils;

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
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userDAO.getUserByEmail(email);
    }
}
