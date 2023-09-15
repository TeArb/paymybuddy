package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.ConnectionToUser;
import com.paymybuddy.paymybuddy.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionToUserRepository extends CrudRepository<ConnectionToUser, Integer> {
    @Query(value = "SELECT * FROM connection_to_user WHERE donor_user = ? AND recipient_user = ?", nativeQuery = true)
    ConnectionToUser findByDonorUserAndRecipientUser(int donor, int recipient);

    List<ConnectionToUser> findByDonorUser(User user);
}
