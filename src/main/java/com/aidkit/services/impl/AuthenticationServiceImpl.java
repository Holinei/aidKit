package com.aidkit.services.impl;

import com.aidkit.dao.IUserDAO;

import com.aidkit.models.User;

import com.aidkit.services.IAuthenticationService;
import org.apache.commons.codec.digest.DigestUtils;

public class AuthenticationServiceImpl implements IAuthenticationService {

    IUserDAO userDAO;

    public AuthenticationServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean authenticateUser(User user) {
        User userFromDb = this.userDAO.getUserByEmail(user.getEmail());
        if (userFromDb != null &&
                userFromDb.getPassword().equals(DigestUtils.md5Hex(user.getPassword()))) {
            return true;
        }
        return false;
    }

    @Override
    public int authenticateRole(User user) {
    return 0;
    }
}
