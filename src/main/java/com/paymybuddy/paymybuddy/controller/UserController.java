package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/home")
    @ModelAttribute("home")
    public String showHomeForm() {
        return "home";
    }

    /**
     * Method to handle login request.
     *
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * Method to handle users.
     *
     */
//    @GetMapping("/users")
//    public String getUsers(@NotNull Model model){
//        Iterable<User> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        return "users";
//    }

    /**
    * Method to handle user registration form request.
    *
    */
    @GetMapping("/register")
    public String registrationForm(@NotNull Model model) {
        // Create model object to store form data.
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    /**
     * Method to handle user registration form submit request.
     *
     */
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") @NotNull User user, BindingResult result, Model model){
        User existingUser = userService.findUserByEmail(user.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email","There email already exist.");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "redirect:/register?error";
        }

        userService.saveUser(user);
        return "redirect:/register?success";
    }

    /**
     * Method to delete a user.
     *
     */
    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/login";
    }

}
