package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.User;

public interface ITransactionService {

    Iterable<Transaction> getTransaction();

    Transaction getTransactionById(Integer id);

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(Integer id);

}
