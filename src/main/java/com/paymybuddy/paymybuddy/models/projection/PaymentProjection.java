package com.paymybuddy.paymybuddy.models.projection;

import com.paymybuddy.paymybuddy.models.User;
import lombok.Value;

public interface PaymentProjection {

    String getEmail();

    Integer getUserId();

    double getAmount();

    String getDescription();

}
