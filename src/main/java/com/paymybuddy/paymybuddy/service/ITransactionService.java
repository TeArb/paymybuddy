package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Transaction;

public interface ITransactionService {

    Iterable<Transaction> getTransactions();

    Transaction getTransactionById(Integer id);

    void saveTransaction(Transaction transaction);

    void deleteTransaction(Integer id);

}
