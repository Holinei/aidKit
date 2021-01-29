package com.aidKit.services;


import com.aidKit.model.User;

import java.util.List;

public interface IUserService {
    void registerUser(User user);

    User getUserByEmail(String email);

    void updateUser(User user);

}
