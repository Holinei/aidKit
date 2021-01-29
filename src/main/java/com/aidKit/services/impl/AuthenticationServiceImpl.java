package com.aidKit.services.impl;

import com.aidKit.dao.IUserDAO;
import com.aidKit.model.Role;
import com.aidKit.model.User;

import com.aidKit.services.IAuthenticationService;
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
        User userFromDb = this.userDAO.getUserByEmail(user.getEmail());

        if (userFromDb != null &&
                userFromDb.getRole().equals(Role.ADMIN) ) {
            return 0;  //ADMIN
        }

        if (userFromDb != null &&
                userFromDb.getRole().equals(Role.USER)) {
            return 1; //STUDENT
        }

        return 2; //OTHER
    }


}
