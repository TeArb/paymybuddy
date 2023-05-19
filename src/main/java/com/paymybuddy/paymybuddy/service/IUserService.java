package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.User;

public interface IUserService {

    Iterable<User> getUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);

}
