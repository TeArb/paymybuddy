package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.UserTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionRepository extends CrudRepository<UserTransaction, Integer> {
}
