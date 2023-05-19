package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.User;

public interface ITransactionService {

    Iterable<Transaction> getTransaction();

    User getTransactionById(Integer id);

    User saveTransaction(Transaction transaction);

    void deleteTransaction(Integer id);

}
