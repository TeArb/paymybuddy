package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repository.ConnectionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.IConnectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectionServiceImpl implements IConnectionService {

    private static final Logger logger = LogManager.getLogger("BankCardServiceImpl");

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private UserRepository userRepository;

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (User) authentication.getPrincipal();
    }

    @Override
    public List<User> getConnections() {
        List<Connection> connectionList = connectionRepository.findByDonorUser(currentUser());
        List<User> result = new ArrayList<>();

        connectionList.forEach(item -> result.add(item.getRecipientUser()));

        return result;
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
    public Connection saveConnection(String email) {
        Connection connection = new Connection();
        User findUser = userRepository.findByEmail(email);

        if (findUser != null && !findUser.equals(currentUser())) {
            Connection existConnection = connectionRepository
                    .findByDonorUserAndRecipientUser(currentUser().getUserId(), findUser.getUserId());
            if (existConnection == null) {
                connection.setRecipientUser(findUser);
                connection.setDonorUser(currentUser());
                connectionRepository.save(connection);
            } else {
                throw new IllegalArgumentException("Connection already exist.");
            }

        } else {
            throw new IllegalArgumentException("Connection can't be null or can't be yourself.");
        }
        return connection;
    }

    @Override
    public void deleteConnection(Integer id) throws Exception {
        User user = currentUser();
        Connection connection = connectionRepository.findByDonorUserAndRecipientUser(user.getUserId(), id);

        if (connection != null) {
            connectionRepository.deleteById(connection.getConnectionId());
        } else {
            throw new Exception("Connection not found");
        }

    }
}
