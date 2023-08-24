package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.Payment;
import com.paymybuddy.paymybuddy.repository.PaymentRepository;
import com.paymybuddy.paymybuddy.service.IPaymentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements IPaymentService {

    private static final Logger logger = LogManager.getLogger("PaymentServiceImpl");

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Iterable<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        Optional<Payment> optional = paymentRepository.findById(id);
        Payment payment;

        if (optional.isPresent()) {
            payment = optional.get();
        } else {
            throw new RuntimeException("Payment not found for id: " + id);
        }
        return payment;
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }
}
