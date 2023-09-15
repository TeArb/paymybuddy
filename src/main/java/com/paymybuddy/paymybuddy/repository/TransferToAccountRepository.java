package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.TransferToAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferToAccountRepository extends CrudRepository<TransferToAccount, Integer> {
}
