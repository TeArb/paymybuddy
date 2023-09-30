package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.TransferToAccount;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.models.UserTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferToAccountRepository extends CrudRepository<TransferToAccount, Integer> {
    // TODO: Add data from different entity
//    List<TransferToAccount> findByUser(User user);

}
