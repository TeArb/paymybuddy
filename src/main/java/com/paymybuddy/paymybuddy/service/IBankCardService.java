package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.User;

public interface IBankCardService {

    Iterable<BankCard> getBankCards();

    BankCard getBankCardById(Integer id);

    BankCard saveBankCard(BankCard bankCard);

    void deleteBankCard(Integer id);

}
