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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_card_Id")
    private int bankCardId;

    @Column(name = "bank_name", nullable=false)
    private String bankName;

    @Column(name = "card_numbers", nullable=false, unique=true)
    private String cardNumbers;

    @Column(name = "secret_code", nullable=false)
    private String secretCode;

    @Column(name = "expiration_date", nullable=false)
    private String expirationDate;

    private String sold;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}
