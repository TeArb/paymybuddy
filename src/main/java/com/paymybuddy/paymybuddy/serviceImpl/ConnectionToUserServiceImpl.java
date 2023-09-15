package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.ConnectionToUser;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repository.ConnectionToUserRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.IConnectionToUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionToUserServiceImpl implements IConnectionToUserService {

    private static final Logger logger = LogManager.getLogger("BankCardServiceImpl");

    @Autowired
    private ConnectionToUserRepository connectionToUserRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Method to get the logged-in user.
     *
     */
    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (User) authentication.getPrincipal();
    }

    /**
     * Method to get connections and put them in a list.
     *
     */
    @Override
    public List<User> getConnections() {
        List<ConnectionToUser> connectionToUserList = connectionToUserRepository.findByDonorUser(currentUser());
        List<User> result = new ArrayList<>();

        connectionToUserList.forEach(item -> result.add(item.getRecipientUser()));

        return result;
    }

    /**
     * Method to save connection with the user email.
     *
     */
    @Override
    public void saveConnection(String email) {
        ConnectionToUser connectionToUser = new ConnectionToUser();
        User findUser = userRepository.findByEmail(email);

        // Save if user exist and different of the current user, in connectionToUser.
        if (findUser != null && !findUser.equals(currentUser())) {
            ConnectionToUser existConnectionToUser = connectionToUserRepository
                    .findByDonorUserAndRecipientUser(currentUser().getUserId(), findUser.getUserId());
            if (existConnectionToUser == null) {
                connectionToUser.setRecipientUser(findUser);
                connectionToUser.setDonorUser(currentUser());
                connectionToUserRepository.save(connectionToUser);
            } else {
                throw new IllegalArgumentException("ConnectionToUser already exist.");
            }

        } else {
            throw new IllegalArgumentException("ConnectionToUser can't be null or can't be yourself.");
        }
    }

    /**
     * Method to delete connection.
     *
     */
    @Override
    public void deleteConnection(Integer id) throws Exception {
        User user = currentUser();
        ConnectionToUser connectionToUser = connectionToUserRepository.findByDonorUserAndRecipientUser(user.getUserId(), id);
        // Condition useful or not?!
        if (connectionToUser != null) {
            connectionToUserRepository.deleteById(connectionToUser.getConnectionId());
        } else {
            throw new Exception("ConnectionToUser not found");
        }

    }
}
