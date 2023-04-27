package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Integer> {
}
