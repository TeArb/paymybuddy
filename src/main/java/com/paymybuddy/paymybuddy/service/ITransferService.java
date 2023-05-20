package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Transfer;
import com.paymybuddy.paymybuddy.models.User;

public interface ITransferService {

    Iterable<Transfer> getTransfers();

    Transfer getTransferById(Integer id);

    Transfer saveTransfer(Transfer transfer);

    void deleteTransfer(Integer id);

}
