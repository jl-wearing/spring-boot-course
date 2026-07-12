package org.example.__payment_service.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class Payment {
    private String id;
    private BigDecimal amount;
}
