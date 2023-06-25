package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.serviceImpl.ConnectionServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ConnectionController {

    @Autowired
    private ConnectionServiceImpl connectionService;

    @GetMapping("/connection")
    public String showConnectionForm(@NotNull Model model) {
        model.addAttribute("connectionemplist", connectionService.getConnections());
        return "connection";
    }

    /**
     * Method to get all connections.
     *
     */
    @GetMapping("/allconnections")
    public Iterable<Connection> getConnections() {
        return connectionService.getConnections();
    }

    /**
     * Method to get connection by id.
     *
     */
//    @GetMapping("/connection")
//    public Connection getConnectionById(@PathVariable Integer id) {
//        return connectionService.getConnectionById(id);
//    }

    /**
     * Method to save a connection.
     *s
     */
    @PostMapping("/saveconnection")
    public String saveConnection(@RequestParam(name = "email") String email) {
        connectionService.saveConnection(email);
        return "redirect:/connection";
    }

    @PostMapping("/test")
    public String test(@RequestParam(name = "email", required = false) String email) {
        connectionService.saveConnection(email);
        System.out.println(email);
        return email;
    }

    /**
     * Method to update a bank card and show in the view.
     *
     */
    @GetMapping("/updateconnection/{id}")
    public String updateConnection(@PathVariable(value = "id") Integer id, @NotNull Model model) {
        Connection connection = connectionService.getConnectionById(id);
        model.addAttribute("connection", connection);
        return "updateconnection";
    }

    /**
     * Method to delete a connection.
     *
     */
    @GetMapping("/deleteconnection/{id}")
    public String deleteConnection(@PathVariable(value = "id") Integer id) {
        connectionService.deleteConnection(id);
        return "redirect:/connection";
    }

}
