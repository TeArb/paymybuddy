package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.models.Transfer;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repository.TransferRepository;
import com.paymybuddy.paymybuddy.service.ITransferService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransferServiceImpl implements ITransferService {

    private static final Logger logger = LogManager.getLogger("TransferServiceImpl");

    @Autowired
    private TransferRepository transferRepository;

    @Override
    public Iterable<Transfer> getTransfers() {
        return transferRepository.findAll();

//        @Override
//        public List<User> getConnections() {
//            List<Connection> connectionList = connectionRepository.findByDonorUser(currentUser());
//            List<User> result = new ArrayList<>();
//
//            connectionList.forEach(item -> result.add(item.getRecipientUser()));
//
//            return result;
//        }

    }

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
    public void saveTransfer(Transfer transfer) {
        transferRepository.save(transfer);
    }

    @Override
    public void deleteTransfer(Integer id) {
        transferRepository.deleteById(id);
    }
}
