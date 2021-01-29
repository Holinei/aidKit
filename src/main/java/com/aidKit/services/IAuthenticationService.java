package com.aidKit.services;

import com.aidKit.model.User;

public interface IAuthenticationService {
    boolean authenticateUser(User user);

    int authenticateRole(User user);

}
