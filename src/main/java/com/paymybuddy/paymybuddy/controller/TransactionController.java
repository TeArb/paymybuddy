package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Transfer;
import com.paymybuddy.paymybuddy.serviceImpl.TransactionServiceImpl;
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
    private TransactionServiceImpl transactionService;

    /**
     * Method to get all bank cards.
     *
     */
    @GetMapping("/transaction")
    public String showTransactionForm(@NotNull Model model) {
        // Create model object to store form data.
//        Tra transfer = new Transfer();
//        model.addAttribute("transfer", transfer);
//        model.addAttribute("transactionemplist", transfer.getBankCards());
        return "transfer";
    }

}
