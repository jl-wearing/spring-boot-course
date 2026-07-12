package org.example.__openfeign.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Payment {
    private String id;
    private BigDecimal amount;
}
