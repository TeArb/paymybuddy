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
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "sold")
    private double sold;

    @Column(name = "today_date")
    private Date todayDate;

    private boolean status;

    private double amount;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "profile_id")
//    private Profile profile;

}
