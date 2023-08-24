package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Generated
@Entity
@Data
@Table(name = "user")
public class User implements UserDetails {
    public User(int userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name", nullable=false)
    private String firstName;

    @Column(name = "last_name", nullable=false)
    private String lastName;

    @Column(nullable=false)
    private String birthdate;

    @Column(name = "phone_number", nullable=false, unique=true)
    @NotEmpty(message = "Email should not be empty")
    private String phoneNumber;

    @Column(nullable=false, unique=true)
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @Column(nullable=false)
    @NotEmpty(message = "Password should not be empty")
    private String password;

//    @Column(nullable=false)
    private String sold;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
