package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userService;
/*
    @GetMapping("/transfer")
    public String viewTransfer(@NotNull Model model) {
        model.addAttribute("transferemplist", userService.getUsers());
        return "viewTransfer";
    }


    @GetMapping("/connection")
    public String viewConnection(@NotNull Model model) {
        model.addAttribute("connectionemplist", userService.getUsers());
        return "viewConnection";
    }*/

    /**
     * Method to get all users.
     *
     */
    @GetMapping("/user")
    public @ResponseBody Iterable<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Method to get users by id.
     *
     */
    @GetMapping("/user/{id}")
    public @ResponseBody User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /**
     * Method to add a user and show in the view.
     *
     */
    @GetMapping("/adduser")
    public String addUser(@NotNull Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }

    /**
     * Method to save a user.
     *
     */
    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute("employee") User user) {
        userService.saveUser(user);
        return "redirect:/transfer";
    }

    /**
     * Method to update a user and show in the view.
     *
     */
    @GetMapping("/showupdateuser/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, @NotNull Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "updateuser";
    }

    /**
     * Method to delete a user.
     *
     */
    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/transfer";
    }

}
