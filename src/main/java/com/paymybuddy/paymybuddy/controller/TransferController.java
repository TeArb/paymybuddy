package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.TransferToAccount;
import com.paymybuddy.paymybuddy.serviceImpl.ConnectionToUserServiceImpl;
import com.paymybuddy.paymybuddy.serviceImpl.TransferToAccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class TransferController {
    @Autowired
    private TransferToAccountServiceImpl transferService;

    @Autowired
    private ConnectionToUserServiceImpl connectionService;

    /**
     * Method to get all transfers.
     *
     */
//    @GetMapping("/alltransfers")
//    public Iterable<TransferToAccount> getTransfers() {
//        return transferService.getTransfers();
//    }

    /**
     * Method to save a transferToAccount.
     *
     */
    @PostMapping("/transferToAccount/save")
    public String saveTransfer(@ModelAttribute("transferToAccount") TransferToAccount transferToAccount, Integer id) {
        transferService.saveTransfer(transferToAccount, id);
        return "redirect:/transferToAccount";
    }

    /**
     * Method to delete a transfer.
     *
     */
    @GetMapping("/deletetransfer/{id}")
    public String deleteTransfer(@PathVariable(value = "id") Integer id) {
        transferService.deleteTransfer(id);
        return "redirect:/transfer";
    }

}
