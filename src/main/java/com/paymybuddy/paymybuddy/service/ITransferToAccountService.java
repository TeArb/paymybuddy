package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.TransferToAccount;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.models.UserTransaction;

import java.util.List;

public interface ITransferToAccountService {

    TransferToAccount getTransferById(Integer id);

    List<UserTransaction> getTransfers();

    TransferToAccount saveTransfer(double amount, Integer idCard);

    void deleteTransfer(Integer id);
}
