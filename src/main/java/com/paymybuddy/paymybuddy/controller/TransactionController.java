package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.UserTransaction;
import com.paymybuddy.paymybuddy.serviceImpl.UserTransactionServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class TransactionController {
    @Autowired
    private UserTransactionServiceImpl transactionService;

    /**
     * Method to get all bank cards.
     *
     */
    @GetMapping("/transfer")
    public String showTransactionForm(@NotNull Model model) {
        // Create model object to store form data.
        UserTransaction userTransaction = new UserTransaction();
        model.addAttribute("transfer", userTransaction);
//        model.addAttribute("transactionemplist", transfer.getBankCards());
        return "transfer";
    }

}
