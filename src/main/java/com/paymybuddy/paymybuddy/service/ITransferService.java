package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Transfer;

public interface ITransferService {

    Iterable<Transfer> getTransfers();

    Transfer getTransferById(Integer id);

    void saveTransfer(Transfer transfer);

    void deleteTransfer(Integer id);

}
