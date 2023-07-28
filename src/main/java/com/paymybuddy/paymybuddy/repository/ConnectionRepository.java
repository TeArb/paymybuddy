package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.Connection;
import com.paymybuddy.paymybuddy.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Integer> {
    @Query(value = "SELECT * FROM connection WHERE donor_user = ? AND recipient_user = ?", nativeQuery = true)
    Connection findByDonorUserAndRecipientUser(int donor, int recipient);

    List<Connection> findByDonorUser(User user);
}
