package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.UserTransaction;

public interface IUserTransactionService {

    Iterable<UserTransaction> getTransactions();

    UserTransaction getTransactionById(Integer id);

    void saveTransaction(UserTransaction userTransaction);

    void deleteTransaction(Integer id);

}
