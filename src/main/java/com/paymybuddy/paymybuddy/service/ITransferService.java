package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Transfer;
import org.jetbrains.annotations.NotNull;

public interface ITransferService {

    Transfer getTransferById(Integer id);

    void saveTransfer(Transfer transfer, Integer id);

    void deleteTransfer(Integer id);
}
