package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Transfer;
import com.paymybuddy.paymybuddy.serviceImpl.ConnectionServiceImpl;
import com.paymybuddy.paymybuddy.serviceImpl.TransferServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class TransferController {
    @Autowired
    private TransferServiceImpl transferService;

    @Autowired
    private ConnectionServiceImpl connectionService;

    /**
     * Method to get all transfers.
     *
     */
//    @GetMapping("/alltransfers")
//    public Iterable<Transfer> getTransfers() {
//        return transferService.getTransfers();
//    }

    /**
     * Method to save a transfer.
     *
     */
    @PostMapping("/transfer/save")
    public String saveTransfer(@ModelAttribute("transfer") Transfer transfer, Integer id) {
        transferService.saveTransfer(transfer, id);
        return "redirect:/transfer";
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
