package com.aidkit.services;


import com.aidkit.models.User;

public interface IUserService {
    void registerUser(User user);

    User getUserByEmail(String email);

    void updateUser(User user);
    User getUserById(int id);
}
