package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LogManager.getLogger("UserServiceImpl");

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Method find user by their email.
     *
     */
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Method to save user.
     *
     */
    @Override
    public void saveUser(@NotNull User newUser) {
        // Encrypt the password using spring security.
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setSold(0);
        userRepository.save(newUser);
    }

    /**
     * Method to delete user.
     *
     */
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
