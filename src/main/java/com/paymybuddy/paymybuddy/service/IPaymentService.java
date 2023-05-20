package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Payment;
import com.paymybuddy.paymybuddy.models.User;

public interface IPaymentService {

    Iterable<Payment> getPayments();

    Payment getPaymentById(Integer id);

    Payment savePayment(Payment payment);

    void deletePayment(Integer id);

}
