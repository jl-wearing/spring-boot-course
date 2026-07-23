package com.example.__transactions.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

public record TransferDto(
        @NotBlank(message = "account ID of sender required")
        String sender,

        @NotBlank(message = "account ID of receiver required")
        String receiver,

        @Positive(message = "amount to transfer must be positive")
        @Range(max = 999999999)
        BigDecimal amount) {}
