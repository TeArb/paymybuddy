package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repository.ConnectionRepository;
import com.paymybuddy.paymybuddy.serviceImpl.ConnectionServiceImpl;
import com.paymybuddy.paymybuddy.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ConnectionController {

    @Autowired
    private ConnectionServiceImpl connectionService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/connection")
    public String showConnectionForm(@NotNull Model model) {
        model.addAttribute("connectionemplist", connectionService.getConnections());
        return "connection";
    }

    /**
     * Method to save a connection.
     *s
     */
    @PostMapping("/saveconnection")
    public String saveConnection(@RequestParam(name = "email") String email) {
        connectionService.saveConnection(email);
        
        return "redirect:/connection";
    }

    /**
     * Method to delete a connection.
     *
     */
    @GetMapping("/deleteconnection/{id}")
    public String deleteConnection(@PathVariable("id") Integer id) throws Exception {
        System.out.println(id);

        connectionService.deleteConnection(id);

        return "redirect:/connection";
    }

}
