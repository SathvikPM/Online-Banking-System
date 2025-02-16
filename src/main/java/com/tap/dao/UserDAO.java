package com.tap.dao;

import com.tap.model.User;

public interface UserDAO {
    void saveUser(User user);
    User getUserByEmailAndPassword(String email, String password);
    boolean emailExists(String email);
}
