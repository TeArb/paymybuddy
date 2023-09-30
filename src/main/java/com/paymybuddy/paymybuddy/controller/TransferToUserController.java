package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.TransferToUser;
import com.paymybuddy.paymybuddy.serviceImpl.ConnectionToUserServiceImpl;
import com.paymybuddy.paymybuddy.serviceImpl.TransferToUserServiceImpl;
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
public class TransferToUserController {

    //TODO: Clean code
    @Autowired
    private ConnectionToUserServiceImpl connectionToUserService;

    @Autowired
    private TransferToUserServiceImpl transferToUserService;
    /**
     * Method to get all payments.
     *
     */
    @GetMapping("/transfertouser")
    public String showTransferForm(@NotNull Model model) {
        // Create model object to store form data.
        TransferToUser payment = new TransferToUser();
        model.addAttribute("transferToUser", payment);
        model.addAttribute("connectionemplist", connectionToUserService.getConnections());
        model.addAttribute("transactionlist",transferToUserService.getUserPayment());
        return "transfer";
    }

    /**
     * Method to save payment.
     *
     */
    @PostMapping("/transfertouser/save")
    public String saveTransferToUser(@RequestParam("amount") double amount, @RequestParam("connection") Integer idConnection) {
        transferToUserService.saveTransferToUser(amount, idConnection);
        return "redirect:/transfertouser";
    }

    /**
     * Method to delete a payment.
     *
     */
    @GetMapping("/transfertouser/delete/{id}")
    public String deletesaveTransferToUser(@PathVariable(value = "id") Integer id) {
        transferToUserService.deleteTransferToUser(id);
        return "redirect:/transfertouser";
    }

}
