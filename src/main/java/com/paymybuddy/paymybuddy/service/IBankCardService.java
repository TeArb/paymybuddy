package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.User;

import java.util.List;

public interface IBankCardService {

    Iterable<BankCard> findAllBankCards();

//    BankCard getBankCardById(Integer id);
    List<BankCard> getBankCards();
    void saveBankCard(BankCard bankCard);

    void deleteBankCard(Integer id);

}
