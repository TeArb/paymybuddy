package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.models.Profile;
import com.paymybuddy.paymybuddy.serviceImpl.ProfileServiceImpl;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProfileController {
    @Autowired
    private ProfileServiceImpl profileService;

    /**
     * Method to get all profiles.
     *
     */
    @GetMapping("/profile")
    public Iterable<Profile> getProfiles() {
        return profileService.getProfiles();
    }

    /**
     * Method to get profile by id.
     *
     */
    @GetMapping("/profile/{id}")
    public Profile getProfileById(@PathVariable Integer id) {
        return profileService.getProfileById(id);
    }

    /**
     * Method to add a profile and show in the view.
     *
     */
    @GetMapping("/addprofile")
    public String addProfile(@NotNull Model model) {
        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        return "newprofile";
    }

    /**
     * Method to save a profile.
     *
     */
    @PostMapping("/saveprofile")
    public String saveProfile(@ModelAttribute("profile") Profile profile) {
        profileService.saveProfile(profile);
        return "redirect:/profile";
    }

    /**
     * Method to update a profile and show in the view.
     *
     */
    @GetMapping("/updateprofile/{id}")
    public String updateProfile(@PathVariable(value = "id") Integer id, @NotNull Model model) {
        Profile profile = profileService.getProfileById(id);
        model.addAttribute("profile", profile);
        return "updateprofile";
    }

    /**
     * Method to delete a profile.
     *
     */
    @GetMapping("/deleteprofile/{id}")
    public String deleteProfile(@PathVariable(value = "id") Integer id) {
        profileService.deleteProfile(id);
        return "redirect:/profile";
    }

}
