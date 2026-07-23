package com.example.__data_source.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record Purchase(
        @NotBlank(message = "purchase name required")
        String name,

        @PositiveOrZero(message = "price must be greater than zero")
        double price) {}
