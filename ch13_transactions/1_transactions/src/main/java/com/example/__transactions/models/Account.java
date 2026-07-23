package com.example.__transactions.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Account {
    private String id;

    @NotBlank(message = "name of customer required")
    private String name;

    @PositiveOrZero(message = "starting balance must be greater than zero.")
    @Range(min = 0, max = 999999999, message = "balance must be between 0 and 999_999_999")
    private BigDecimal balance;
}
