package org.example.dynamic_view_2_cart.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private BigDecimal price;
}
