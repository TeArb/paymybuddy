package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.models.User;

public interface IConnectionService {

    Iterable<Connection> getConnections();

    Connection getConnectionById(Integer id);

    Connection saveConnection(Connection connection);

    void deleteConnection(Integer id);

}
