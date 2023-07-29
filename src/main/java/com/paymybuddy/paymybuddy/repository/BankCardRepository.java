package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Integer> {

    List<BankCard> findByUser(User user);

}

