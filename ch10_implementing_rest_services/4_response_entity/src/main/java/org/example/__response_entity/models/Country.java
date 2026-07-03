package org.example.__response_entity.models;

import lombok.Builder;

@Builder
public record Country(String name, int population) {}
