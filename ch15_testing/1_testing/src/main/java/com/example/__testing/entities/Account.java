package com.example.__testing.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Account {
    @Id
    private Integer id;
    private String name;
    private BigDecimal amount;
}
