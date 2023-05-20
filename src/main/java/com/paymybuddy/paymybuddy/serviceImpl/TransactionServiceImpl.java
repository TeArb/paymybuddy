package com.paymybuddy.paymybuddy.serviceImpl;


import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.repository.TransactionRepository;
import com.paymybuddy.paymybuddy.service.ITransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements ITransactionService {

    private static final Logger logger = LogManager.getLogger("TransactionServiceImpl");

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Iterable<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Integer id) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        Transaction transaction;

        if (optional.isPresent()) {
            transaction = optional.get();
        } else {
            throw new RuntimeException("Transaction not found for id: " + id);
        }
        return transaction;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}
