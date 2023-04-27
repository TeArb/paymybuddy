package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * Method to get a user.
     *
     */
    @GetMapping("/user")
    public @ResponseBody Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public @ResponseBody Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

}
