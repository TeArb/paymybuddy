package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.repository.ConnectionRepository;
import com.paymybuddy.paymybuddy.service.IConnectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConnectionServiceImpl implements IConnectionService {

    private static final Logger logger = LogManager.getLogger("BankCardServiceImpl");

    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public Iterable<Connection> getConnections() {
        return connectionRepository.findAll();
    }

    @Override
    public Connection getConnectionById(Integer id) {
        Optional<Connection> optional = connectionRepository.findById(id);
        Connection connection;

        if (optional.isPresent()) {
            connection = optional.get();
        } else {
            throw new RuntimeException("Connection not found for id: " + id);
        }
        return connection;
    }

    @Override
    public Connection saveConnection(Connection connection) {
        return connectionRepository.save(connection);
    }

    @Override
    public void deleteConnection(Integer id) {
        connectionRepository.deleteById(id);
    }
}
