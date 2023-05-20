package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LogManager.getLogger("UserServiceImpl");

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        User user;

        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for id: " + id);
        }
        return user;
    }

    @Override
    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
