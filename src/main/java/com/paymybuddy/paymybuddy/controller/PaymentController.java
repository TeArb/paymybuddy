package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Payment;
import com.paymybuddy.paymybuddy.serviceImpl.PaymentServiceImpl;
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
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    /**
     * Method to get all payments.
     *
     */
    @GetMapping("/payment")
    public Iterable<Payment> getPayments() {
        return paymentService.getPayments();
    }

    /**
     * Method to get payment by id.
     *
     */
    @GetMapping("/payment/{id}")
    public Payment getPaymentById(@PathVariable Integer id) {
        return paymentService.getPaymentById(id);
    }

    /**
     * Method to add a payment and show in the view.
     *
     */
    @GetMapping("/addpayment")
    public String addPayment(@NotNull Model model) {
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "newpayment";
    }

    /**
     * Method to save a payment.
     *
     */
    @PostMapping("/savepayment")
    public String savePayment(@ModelAttribute("payment") Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payment";
    }

    /**
     * Method to update a payment and show in the view.
     *
     */
    @GetMapping("/updatepayment/{id}")
    public String updatePayment(@PathVariable(value = "id") Integer id, @NotNull Model model) {
        Payment payment = paymentService.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "updatepayment";
    }

    /**
     * Method to delete a payment.
     *
     */
    @GetMapping("/deletepayment/{id}")
    public String deletePayment(@PathVariable(value = "id") Integer id) {
        paymentService.deletePayment(id);
        return "redirect:/payment";
    }

}
