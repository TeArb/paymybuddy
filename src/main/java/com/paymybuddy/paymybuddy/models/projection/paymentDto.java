package com.paymybuddy.paymybuddy.models.projection;

import com.paymybuddy.paymybuddy.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class paymentDto {

    private User beneficiary;

    private double amount;

    private String descriptionTransaction;

}
