package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.User;

import java.util.List;

public interface IConnectionService {

    List<User> getConnections();

    void saveConnection(String email);

    void deleteConnection(Integer id) throws Exception;
}
