package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Generated
@Entity
@Data
@Table(name = "bank_card")
public class BankCard {

    // Add more setting for the bdd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_card_Id")
    private int bankCardId;

    @Column(name = "bank_name", nullable=false)
    private String bankName;

    @Column(name = "card_number", nullable=false, unique=true)
    private int cardNumber;

    @Column(name = "secret_code", nullable=false)
    private int secretCode;

    @Column(name = "expiration_date", nullable=false)
    private Date expirationDate;

    @Column(name = "sold_account", nullable=false)
    private double soldAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}
