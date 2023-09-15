package com.paymybuddy.paymybuddy.serviceImpl;


import com.paymybuddy.paymybuddy.models.UserTransaction;
import com.paymybuddy.paymybuddy.repository.UserTransactionRepository;
import com.paymybuddy.paymybuddy.service.IUserTransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserTransactionServiceImpl implements IUserTransactionService {

    private static final Logger logger = LogManager.getLogger("UserTransactionServiceImpl");

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    @Override
    public Iterable<UserTransaction> getTransactions() {
        return userTransactionRepository.findAll();
    }

    @Override
    public UserTransaction getTransactionById(Integer id) {
        Optional<UserTransaction> optional = userTransactionRepository.findById(id);
        UserTransaction userTransaction;

        if (optional.isPresent()) {
            userTransaction = optional.get();
        } else {
            throw new RuntimeException("UserTransaction not found for id: " + id);
        }
        return userTransaction;
    }

    @Override
    public void saveTransaction(UserTransaction userTransaction) {
        TransferToAccountServiceImpl transferService = new TransferToAccountServiceImpl();
//        userTransaction.setDescriptionTransaction();
        userTransaction.setTodayDate(new Date());
        userTransactionRepository.save(userTransaction);
    }

    @Override
    public void deleteTransaction(Integer id) {
        userTransactionRepository.deleteById(id);
    }
}
