package com.paymybuddy.paymybuddy.models.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    @Id
    private Integer paymentDtoId;

    private String beneficiary;

    private double amount;

    private String descriptionTransaction;

}
