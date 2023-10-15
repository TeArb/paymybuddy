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
@Table(name = "transfer_to_user")
public class TransferToUser {

    // TODO: Add more setting for the bdd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transfer_to_user_id")
    private int transferToUserId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "beneficiary_user_id")
    private User beneficiary;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_transaction_id")
    private UserTransaction userTransaction;

}
