package com.example.__testing.entities.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class TransferDto {
    @PositiveOrZero(message = "sender id is required")
    private Integer senderId;

    @PositiveOrZero(message = "receiver id is required")
    private Integer receiverId;

    @Range(min = 0, max = 500_000, message = "amount to transfer cannot be more than $500 000 at a time")
    private BigDecimal amount;
}
