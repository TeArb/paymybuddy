package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.serviceImpl.TransactionServiceImpl;
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
public class TransactionController {
    @Autowired
    private TransactionServiceImpl transactionService;

    /**
     * Method to get all transactions.
     *
     */
    @GetMapping("/transaction")
    public Iterable<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    /**
     * Method to get transaction by id.
     *
     */
    @GetMapping("/transaction/{id}")
    public Transaction getTransactionById(@PathVariable Integer id) {
        return transactionService.getTransactionById(id);
    }

    /**
     * Method to add a transaction and show in the view.
     *
     */
    @GetMapping("/addtransaction")
    public String addTransaction(@NotNull Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "newtransaction";
    }

    /**
     * Method to save a transaction.
     *
     */
    @PostMapping("/savetransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transaction";
    }

    /**
     * Method to update a transaction and show in the view.
     *
     */
    @GetMapping("/updatetransaction/{id}")
    public String updateTransaction(@PathVariable(value = "id") Integer id, @NotNull Model model) {
        Transaction transaction = transactionService.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        return "updatetransaction";
    }

    /**
     * Method to delete a transaction.
     *
     */
    @GetMapping("/deletetransaction/{id}")
    public String deleteProfile(@PathVariable(value = "id") Integer id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transaction";
    }

}
