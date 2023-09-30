package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.TransferToUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferToUserRepository extends CrudRepository<TransferToUser, Integer> {
}
