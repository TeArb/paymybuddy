package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Transfer;
import com.paymybuddy.paymybuddy.models.User;

public interface ITransferService {

    Iterable<Transfer> getTransfer();

    User getTransferById(Integer id);

    User saveTransfer(Transfer transfer);

    void deleteTransfer(Integer id);

}
