package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Transfer;
import com.paymybuddy.paymybuddy.serviceImpl.TransferServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class TransferController {
    @Autowired
    private TransferServiceImpl transferService;

    @GetMapping("/transfer")
    public String viewTransfer(@NotNull Model model) {
        model.addAttribute("transferemplist", transferService.getTransfers());
        return "viewTransfer";
    }

    /**
     * Method to get all transfers.
     *
     */
    @GetMapping("/alltransfers")
    public Iterable<Transfer> getTransfers() {
        return transferService.getTransfers();
    }

    /**
     * Method to get transfer by id.
     *
     */
    @GetMapping("/transfer/{id}")
    public Transfer getTransferById(@PathVariable Integer id) {
        return transferService.getTransferById(id);
    }

    /**
     * Method to add a transfer and show in the view.
     *
     */
    @GetMapping("/addtransfer")
    public String addTransaction(@NotNull Model model) {
        Transfer transfer = new Transfer();
        model.addAttribute("transfer", transfer);
        return "newtransfer";
    }

    /**
     * Method to save a transfer.
     *
     */
    @PostMapping("/savetransfer")
    public String saveTransfer(@ModelAttribute("transfer") Transfer transfer) {
        transferService.saveTransfer(transfer);
        return "redirect:/transfer";
    }

    /**
     * Method to update a transfer and show in the view.
     *
     */
    @GetMapping("/updatetransfer/{id}")
    public String updateTransfer(@PathVariable(value = "id") Integer id, @NotNull Model model) {
        Transfer transfer = transferService.getTransferById(id);
        model.addAttribute("transfer", transfer);
        return "updatetransfer";
    }

    /**
     * Method to delete a transfer.
     *
     */
    @GetMapping("/deletetransfer/{id}")
    public String deleteProfile(@PathVariable(value = "id") Integer id) {
        transferService.deleteTransfer(id);
        return "redirect:/transfer";
    }

}
