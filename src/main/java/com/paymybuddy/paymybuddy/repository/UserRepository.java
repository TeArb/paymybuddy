package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

//    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

}
