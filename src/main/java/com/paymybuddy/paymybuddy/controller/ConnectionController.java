package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.serviceImpl.ConnectionToUserServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ConnectionController {

    @Autowired
    private ConnectionToUserServiceImpl connectionService;

    /**
     * Method to request a get all connections and display it in the view.
     *
     */
    @GetMapping("/connection")
    public String showConnectionForm(@NotNull Model model) {
        // Add connections for the view
        model.addAttribute("connectionemplist", connectionService.getConnections());
        return "connection";
    }

    /**
     * Method to request a save connection.
     *
     */
    @PostMapping("/connection/save")
    public String saveConnection(@RequestParam(name = "email") String email) {
        // Add has error for the form and see for the binding + model
        connectionService.saveConnection(email);
        
        return "redirect:/connection";
    }

    /**
     * Method to request a delete  connection.
     *
     */
    @GetMapping("/deleteconnection/{id}")
    public String deleteConnection(@PathVariable("id") Integer id) throws Exception {
        connectionService.deleteConnection(id);

        return "redirect:/connection";
    }

}
