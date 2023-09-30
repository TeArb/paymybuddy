package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.TransferToAccount;
import com.paymybuddy.paymybuddy.serviceImpl.BankCardServiceImpl;
import com.paymybuddy.paymybuddy.serviceImpl.ConnectionToUserServiceImpl;
import com.paymybuddy.paymybuddy.serviceImpl.TransferToAccountServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class TransferToAccountController {

    //TODO: Clean code
    @Autowired
    private TransferToAccountServiceImpl transferService;

    @Autowired
    private ConnectionToUserServiceImpl connectionService;

    @Autowired
    private BankCardServiceImpl bankCardService;

    /**
     * Method to get all transfers.
     *
     */
//    @GetMapping("/alltransfers")
//    public Iterable<TransferToAccount> getTransfers() {
//        return transferService.getTransfers();
//    }

    @GetMapping("/transfertoaccount")
    public String showTransferToAccountForm(@NotNull Model model) {
        // Create model object to store form data.
        TransferToAccount transfer = new TransferToAccount();
        model.addAttribute("transferToAccount", transfer);
        model.addAttribute("bankcardemplist", bankCardService.getBankCards());
//        model.addAttribute("transferemplist", transferService.getTransfers());
        return "transferToAccount";
    }

    /**
     * Method to save a transfer.
     *
     */
    @PostMapping("/transfertoaccount/save")
    public String saveTransfer(@RequestParam("amount") double amount, @RequestParam("bankCard") Integer idCard) {
        transferService.saveTransfer(amount, idCard);
        return "redirect:/transfertoaccount";
    }

    /**
     * Method to delete a transfer.
     *
     */
    @GetMapping("/transfertoaccount/delete/{id}")
    public String deleteTransfer(@PathVariable(value = "id") Integer id) {
        transferService.deleteTransfer(id);
        return "redirect:/transfertoaccount";
    }

}
