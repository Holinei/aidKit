package com.aidkit.services;

import com.aidkit.models.User;

public interface IAuthenticationService {
    boolean authenticateUser(User user);

    int authenticateRole(User user);
}
