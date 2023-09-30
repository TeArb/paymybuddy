package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.models.UserTransaction;
import com.paymybuddy.paymybuddy.models.TransferToAccount;
import com.paymybuddy.paymybuddy.repository.BankCardRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.repository.UserTransactionRepository;
import com.paymybuddy.paymybuddy.repository.TransferToAccountRepository;
import com.paymybuddy.paymybuddy.service.ITransferToAccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferToAccountServiceImpl implements ITransferToAccountService {

    private static final Logger logger = LogManager.getLogger("TransferToAccountServiceImpl");

    private TransferToAccount transfer;

    @Autowired
    private TransferToAccountRepository transferToAccountRepository;

    @Autowired
    private BankCardRepository bankCardRepository;

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    @Autowired
    private UserRepository userRepository;
    // TODO: comments

    private User connectionUser() {
        ConnectionToUserServiceImpl connectionToUserServiceImpl = new ConnectionToUserServiceImpl();
        return connectionToUserServiceImpl.currentUser();
    }

    @Override
    public TransferToAccount getTransferById(Integer id) {
        Optional<TransferToAccount> optionalTransferToAccount = transferToAccountRepository.findById(id);

        if (optionalTransferToAccount.isPresent()) {
            transfer = optionalTransferToAccount.get();
        } else {
            throw new RuntimeException("Transfer to account not found for id: " + id);
        }

        return transfer;
    }
    // TODO: Make a list of user transaction items
    @Override
    public List<UserTransaction> getTransfers() {
//        List<TransferToAccount> transferToAccountList = transferToAccountRepository.findByUser(connectionUser());
//        List<User> result = new ArrayList<>();
//
//        transferToAccountList.forEach(item -> result.add(item.getUserTransaction()));

        return null;
    }


    @Override
    public TransferToAccount saveTransfer(double amount, Integer idCard) {
        //TODO: Add error handling
        UserTransaction transaction = new UserTransaction();
        transfer = new TransferToAccount();

        transaction.setTypeTransaction("Transfer");
        transaction.setAmount(amount);
        transaction.setUser(connectionUser());
        transaction.setDescriptionTransaction("transfer: " + connectionUser().getUsername());
        transaction.setTodayDate(new Date());

        transaction = userTransactionRepository.save(transaction);

        transfer.setUserTransaction(transaction);
        transfer.setBankCard(new BankCard(idCard));

        transferToAccountRepository.save(transfer);

        connectionUser().setSold(connectionUser().getSold() + amount);

        userRepository.save(connectionUser());
        
        return transfer;
    }

    @Override
    public void deleteTransfer(Integer id) {
        transferToAccountRepository.deleteById(id);
    }
}
