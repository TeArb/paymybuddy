package com.paymybuddy.paymybuddy.serviceImpl;

import com.paymybuddy.paymybuddy.models.Profile;
import com.paymybuddy.paymybuddy.repository.ProfileRepository;
import com.paymybuddy.paymybuddy.service.IProfileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements IProfileService {

    private static final Logger logger = LogManager.getLogger("ProfileServiceImpl");

    @Autowired
    private ProfileRepository profileRepository;


    @Override
    public Iterable<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileById(Integer id) {
        Optional<Profile> optional = profileRepository.findById(id);
        Profile profile;

        if (optional.isPresent()) {
            profile = optional.get();
        } else {
            throw new RuntimeException("Profile not found for id: " + id);
        }
        return profile;
    }

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Integer id) {
        profileRepository.deleteById(id);
    }
}
