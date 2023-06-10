package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.User;

public interface IUserService {

    Iterable<User> findAllUsers();

    User findUserByEmail(String email);

    User saveUser(User newUser);

    void deleteUser(Integer id);

}
