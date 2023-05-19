package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.User;

public interface IBankCardService {

    Iterable<BankCard> getBankCard();

    User getBankCardById(Integer id);

    User saveBankCard(BankCard bankCard);

    void deleteBankCard(Integer id);

}
