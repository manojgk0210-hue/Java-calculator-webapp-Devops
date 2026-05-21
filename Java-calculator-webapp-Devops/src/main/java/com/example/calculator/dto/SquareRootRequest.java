package com.example.calculator.dto;

import jakarta.validation.constraints.NotNull;

public record SquareRootRequest(
        @NotNull(message = "number cannot be null")
        Double number
) {
}
