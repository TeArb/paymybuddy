package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.BankCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Integer> {
}
