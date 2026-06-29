package org.example.get_post_5.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Product {
    private String name;
    private BigDecimal price;
}
