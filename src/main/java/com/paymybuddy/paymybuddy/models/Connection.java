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
@Table(name = "connection")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private int connectionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "donor_profile")
    private Profile donorProfile;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient_profile")
    private Profile recipientProfile;

}
