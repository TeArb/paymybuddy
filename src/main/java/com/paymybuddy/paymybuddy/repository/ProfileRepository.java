package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
