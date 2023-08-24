package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.serviceImpl.ConnectionServiceImpl;
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
    private ConnectionServiceImpl connectionService;

    /**
     * Method to get all connections.
     *
     */
    @GetMapping("/connection")
    public String showConnectionForm(@NotNull Model model) {
        model.addAttribute("connectionemplist", connectionService.getConnections());
        return "connection";
    }

    /**
     * Method to save a connection.
     *
     */
    @PostMapping("/connection/save")
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
        connectionService.deleteConnection(id);

        return "redirect:/connection";
    }

}
