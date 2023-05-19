package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.models.Profile;
import com.paymybuddy.paymybuddy.models.User;

public interface IProfileService {

    Iterable<Profile> getProfile();

    User getProfileById(Integer id);

    User saveProfile(Profile profile);

    void deleteProfile(Integer id);

}
