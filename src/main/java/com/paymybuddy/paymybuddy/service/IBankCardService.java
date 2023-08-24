package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.BankCard;

import java.util.List;

public interface IBankCardService {

    BankCard getBankCardById(Integer id);

    List<BankCard> getBankCards();

    void saveBankCard(BankCard bankCard);

    void deleteBankCard(Integer id);

}
