package com.paymybuddy.paymybuddy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Generated
@Entity
@Data
@Table(name = "transfer_to_account")
public class TransferToAccount {

    // TODO: Add more setting for the bdd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transfer_to_account_id")
    private int transferToAccountId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_card_id")
    private BankCard bankCard;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_transaction_id")
    private UserTransaction userTransaction;

}
