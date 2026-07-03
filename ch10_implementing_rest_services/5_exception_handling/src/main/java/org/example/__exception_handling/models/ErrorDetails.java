package org.example.__exception_handling.models;

import lombok.Builder;

@Builder
public record ErrorDetails(String message) {
}
