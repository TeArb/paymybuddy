package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.TransferToUser;

public interface ITransferToUserService {

    TransferToUser getTransferToUserBy(Integer id);

    TransferToUser saveTransferToUser(double amount, Integer idConnection);

    void deleteTransferToUser(Integer id);

}
