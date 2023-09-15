package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.TransferToAccount;

public interface ITransferToAccountService {

    TransferToAccount getTransferById(Integer id);

    void saveTransfer(TransferToAccount transferToAccount, Integer id);

    void deleteTransfer(Integer id);
}
