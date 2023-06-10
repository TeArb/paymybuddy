package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.serviceImpl.ConnectionServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/connection/{id}")
    public Connection getConnectionById(@PathVariable Integer id) {
        return connectionService.getConnectionById(id);
    }

    /**
     * Method to add a connection and show in the view.
     *
     */
    @GetMapping("/addconnection")
    public String addConnection(@NotNull Model model) {
        Connection connection = new Connection();
        model.addAttribute("connection", connection);
        return "newconnection";
    }

    /**
     * Method to save a connection.
     *
     */
    @PostMapping("/saveconnection")
    public String saveConnection(@ModelAttribute("connection") Connection connection) {
        connectionService.saveConnection(connection);
        return "redirect:/connection";
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
