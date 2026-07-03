package org.example.__dtos.models;

import lombok.Builder;

@Builder
public record Country(String name, int population) {
}
