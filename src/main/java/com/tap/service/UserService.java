package com.tap.service;

import com.tap.model.User;

public interface UserService {
    void saveUser(User user);
    User getUserByEmailAndPassword(String email, String password);
    boolean emailExists(String email);
}
