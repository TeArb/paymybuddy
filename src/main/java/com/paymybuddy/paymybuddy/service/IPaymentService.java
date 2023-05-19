package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Payment;
import com.paymybuddy.paymybuddy.models.User;

public interface IPaymentService {

    Iterable<Payment> getPayment();

    User getPaymentById(Integer id);

    User savePayment(Payment payment);

    void deletePayment(Integer id);

}
