package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Payment;

public interface IPaymentService {

    Iterable<Payment> getPayments();

    Payment getPaymentById(Integer id);

    void savePayment(Payment payment);

    void deletePayment(Integer id);

}
