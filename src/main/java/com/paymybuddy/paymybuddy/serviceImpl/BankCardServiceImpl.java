package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.repository.BankCardRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.IBankCardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankCardServiceImpl implements IBankCardService {

    private static final Logger logger = LogManager.getLogger("BankCardServiceImpl");

    @Autowired
    private BankCardRepository bankCardRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Method to get bank card by id.
     *
     */
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

    /**
     * Method to get bank cards and put them in a list.
     *
     */
    @Override
    public List<BankCard> getBankCards() {
        ConnectionToUserServiceImpl connectionService = new ConnectionToUserServiceImpl();

        return bankCardRepository.findByUser(connectionService.currentUser());
    }

    /**
     * Method to save bank cards.
     *
     */
    @Override
    public void saveBankCard(@NotNull BankCard bankCard) {
        ConnectionToUserServiceImpl connectionService = new ConnectionToUserServiceImpl();

        // Add condition if BC already exist

        bankCard.setUser(connectionService.currentUser());
        bankCard.setSoldAccount(1000000);
        System.out.println("TEST: " + bankCard);

        bankCardRepository.save(bankCard);
        System.out.println("TEST: " + bankCard);
    }

    /**
     * Method to delete bank cards.
     *
     */
    @Override
    public void deleteBankCard(Integer id) {
        bankCardRepository.deleteById(id);
    }
}
