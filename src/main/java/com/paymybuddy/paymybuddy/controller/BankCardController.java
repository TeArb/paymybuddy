package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.serviceImpl.BankCardServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BankCardController {

    @Autowired
    private BankCardServiceImpl bankCardService;

    /**
     * Method to get all bank cards and the view.
     *
     */
    @GetMapping("/bankcard")
    public String showBankCardForm(@NotNull Model model) {
        // Create model object to store form data.
        BankCard bankCard = new BankCard();
        model.addAttribute("bankCard", bankCard);
        // Add bank cards and display it in the view.
        model.addAttribute("bankcardemplist", bankCardService.getBankCards());
        return "bankCard";
    }

    /**
     * Method to save a bank card.
     *
     */
    @PostMapping("/bankcard/save")
    public String saveBankCard(@ModelAttribute("bankcard") BankCard bankCard, @NotNull BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("bankcard", bankCard);
            return "redirect:/bankcard";
        }

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
