package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Integer> {
}
