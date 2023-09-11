package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.Transfer;
import com.paymybuddy.paymybuddy.repository.TransactionRepository;
import com.paymybuddy.paymybuddy.repository.TransferRepository;
import com.paymybuddy.paymybuddy.service.ITransferService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TransferServiceImpl implements ITransferService {

    private static final Logger logger = LogManager.getLogger("TransferServiceImpl");

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transfer getTransferById(Integer id) {
        Optional<Transfer> optional = transferRepository.findById(id);
        Transfer transfer;

        if (optional.isPresent()) {
            transfer = optional.get();
        } else {
            throw new RuntimeException("Transfer not found for id: " + id);
        }
        return transfer;
    }

    @Override
    public void saveTransfer(@NotNull Transfer transfer, Integer id) {
        ConnectionServiceImpl connectionService = new ConnectionServiceImpl();
        Transaction transaction = new Transaction();

        BankCard bankCard = new BankCard();

        transfer.setTransaction(transaction);
        transfer.setBankCard(bankCard);

        transferRepository.save(transfer);
    }

    @Override
    public void deleteTransfer(Integer id) {
        transferRepository.deleteById(id);
    }
}
