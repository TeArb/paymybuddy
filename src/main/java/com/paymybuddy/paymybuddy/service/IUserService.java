package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.User;

import java.util.Optional;

public interface IUserService {

    Iterable<User> getUsers();

    Optional<User> getUserById(Integer id);

    User addUser(User user);

//    User updateUser(User user, String[] params);

    User updateUser(User newUser, int userId);

    void deleteUser(Integer id);

}
