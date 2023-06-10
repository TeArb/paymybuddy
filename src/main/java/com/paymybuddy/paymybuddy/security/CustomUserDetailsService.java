package com.paymybuddy.paymybuddy.security;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.models.UserPrincipal;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(usernameOrEmail);
        if (user != null) {
            return new UserPrincipal(user);
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }

}
