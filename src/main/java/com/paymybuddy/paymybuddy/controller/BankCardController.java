package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repository.BankCardRepository;
import com.paymybuddy.paymybuddy.serviceImpl.BankCardServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class BankCardController {

    @Autowired
    private BankCardServiceImpl bankCardService;

    @GetMapping("/bankcard")
    public String showBankCardForm(@NotNull Model model) {
        // Create model object to store form data.
        BankCard bankCard = new BankCard();
        model.addAttribute("bankCard", bankCard);
        System.out.println(bankCardService.getBankCards().size());
        model.addAttribute("bankcardemplist", bankCardService.getBankCards());
        return "bankCard";
    }

    /**
     * Method to get all bank cards.
     *
     */
//    @GetMapping("/bankCardsList")
//    public String getBankCards(@NotNull Model model){
//        model.addAttribute("bankcardemplist", bankCardService.getBankCards());
//        return "bankCard";
//    }


    /**
     * Method to get bank card by id.
     *
     */
//    @GetMapping("/bankcard/{id}")
//    public BankCard getBankCardById(@PathVariable Integer id) {
//        return bankCardService.getBankCardById(id);
//    }

    /**
     * Method to add a bank card and show in the view.
     *
     */
//    @GetMapping("/addbankcard")
//    public String addBankCard(@NotNull Model model) {
//        BankCard bankCard = new BankCard();
//        model.addAttribute("bankcard", bankCard);
//        return "bankCard";
//    }

    /**
     * Method to save a bank card.
     *
     */
    @PostMapping("/bankcard/save")
    public String saveBankCard(@ModelAttribute("bankcard") BankCard bankCard) {
        bankCardService.saveBankCard(bankCard);
        return "redirect:/bankcard";
    }


    /**
     * Method to delete a bank card.
     *
     */
    @GetMapping("/deletebankcard/{id}")
    public String deleteBankcard(@PathVariable(value = "id") Integer id) {
        bankCardService.deleteBankCard(id);
        return "redirect:/bankcard";
    }

}
