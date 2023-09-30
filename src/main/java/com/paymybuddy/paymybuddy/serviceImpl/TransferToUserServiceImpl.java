package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.TransferToUser;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.models.UserTransaction;
import com.paymybuddy.paymybuddy.models.dto.PaymentDto;
import com.paymybuddy.paymybuddy.repository.TransferToUserRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.repository.UserTransactionRepository;
import com.paymybuddy.paymybuddy.service.ITransferToUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferToUserServiceImpl implements ITransferToUserService {

    private static final Logger logger = LogManager.getLogger("TransferToUserServiceImpl");

    @Autowired
    private TransferToUserRepository transferToUserRepository;

    @Autowired
    private ConnectionToUserServiceImpl connectionToUserService;

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    private TransferToUser payment;

    @Autowired
    private UserRepository userRepository;

    private User connectionUser() {
        ConnectionToUserServiceImpl connectionToUserServiceImpl = new ConnectionToUserServiceImpl();
        return connectionToUserServiceImpl.currentUser();
    }

    public List<PaymentDto> getUserPayment() {
        return userTransactionRepository.paymentByCurrentUser(connectionUser().getUserId());
    }

    // TODO: comments
    @Override
    public TransferToUser getTransferToUserBy(Integer id) {
        Optional<TransferToUser> optionalTransferToUser = transferToUserRepository.findById(id);

        if (optionalTransferToUser.isPresent()) {
            payment = optionalTransferToUser.get();
        } else {
            throw new RuntimeException("Transfer to user not found for id: " + id);
        }

        return payment;
    }

    @Override
    public TransferToUser saveTransferToUser(double amount, Integer idConnection) {
        //TODO: Add error handling
        UserTransaction transaction = new UserTransaction();
        payment = new TransferToUser();

        transaction.setDescriptionTransaction("Payment");
        transaction.setAmount(amount);
        transaction.setUser(connectionUser());
        transaction.setTypeTransaction("Payment for ");
        transaction.setTodayDate(new Date());

        transaction = userTransactionRepository.save(transaction);

        payment.setUserTransaction(transaction);
        payment.setBeneficiary(new User(idConnection));

        transferToUserRepository.save(payment);

        connectionUser().setSold(connectionUser().getSold() - amount);

        userRepository.save(connectionUser());

        return payment;
    }

    @Override
    public void deleteTransferToUser(Integer id) {
        transferToUserRepository.deleteById(id);
    }
}
