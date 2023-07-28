package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.models.User;

import java.util.List;

public interface IConnectionService {

    List<User> getConnections();

    Connection getConnectionById(Integer id);

    Connection saveConnection(String email);

//    List<User> deleteConnection(Integer id);

    void deleteConnection(Integer id) throws Exception;
}
