package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.UserTransaction;
import com.paymybuddy.paymybuddy.models.TransferToAccount;
import com.paymybuddy.paymybuddy.repository.BankCardRepository;
import com.paymybuddy.paymybuddy.repository.UserTransactionRepository;
import com.paymybuddy.paymybuddy.repository.TransferToAccountRepository;
import com.paymybuddy.paymybuddy.service.ITransferToAccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferToAccountServiceImpl implements ITransferToAccountService {

    private static final Logger logger = LogManager.getLogger("TransferToAccountServiceImpl");

    @Autowired
    private TransferToAccountRepository transferToAccountRepository;

    @Autowired
    private BankCardRepository bankCardRepository;

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    @Override
    public TransferToAccount getTransferById(Integer id) {
        Optional<TransferToAccount> optional = transferToAccountRepository.findById(id);
        TransferToAccount transferToAccount;

        if (optional.isPresent()) {
            transferToAccount = optional.get();
        } else {
            throw new RuntimeException("TransferToAccount not found for id: " + id);
        }
        return transferToAccount;
    }

    @Override
    public void saveTransfer(@NotNull TransferToAccount transferToAccount, Integer id) {
        // Add error handling

        // Get the card number
        transferToAccount.setBankCard(bankCardRepository.findByCardNumber(id));
        // Get the id of the userTransaction
        transferToAccount.setUserTransaction(getTransferById(id).getUserTransaction());
        UserTransaction userTransaction = new UserTransaction();
        userTransaction.setTypeTransaction("TransferToAccount");

        System.out.println(transferToAccount);

        transferToAccountRepository.save(transferToAccount);
    }

    @Override
    public void deleteTransfer(Integer id) {
        transferToAccountRepository.deleteById(id);
    }
}
