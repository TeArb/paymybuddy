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
@Table(name = "connection_to_user")
public class ConnectionToUser {

    // TODO: Add more setting for the bdd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private int connectionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "donor_user")
    private User donorUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient_user")
    private User recipientUser;

}