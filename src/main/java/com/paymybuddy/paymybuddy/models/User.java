package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Generated
@Entity
@Data
@Table(name = "user")
public class User {

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
    private String phoneNumber;

    @Column(nullable=false, unique=true)
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @Column(nullable=false)
    @NotEmpty(message = "Password should not be empty")
    private String password;

}
