package com.example.__spring_data.entities.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class TransferDto {
    private Integer idSender;
    private Integer idReceiver;
    private BigDecimal amount;
}
