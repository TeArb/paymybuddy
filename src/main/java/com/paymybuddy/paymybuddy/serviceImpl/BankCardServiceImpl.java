package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.repository.BankCardRepository;
import com.paymybuddy.paymybuddy.service.IBankCardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankCardServiceImpl implements IBankCardService {

    private static final Logger logger = LogManager.getLogger("BankCardServiceImpl");

    @Autowired
    private BankCardRepository bankCardRepository;

    @Override
    public Iterable<BankCard> getBankCard() {
        return bankCardRepository.findAll();
    }

    @Override
    public BankCard getBankCardById(Integer id) {
        Optional<BankCard> optional = bankCardRepository.findById(id);
        BankCard bankCard;

        if (optional.isPresent()) {
            bankCard = optional.get();
        } else {
            throw new RuntimeException("BankCard not found for id: " + id);
        }
        return bankCard;
    }

    @Override
    public BankCard saveBankCard(BankCard bankCard) {
        return bankCardRepository.save(bankCard);
    }

    @Override
    public void deleteBankCard(Integer id) {
        bankCardRepository.deleteById(id);
    }
}
