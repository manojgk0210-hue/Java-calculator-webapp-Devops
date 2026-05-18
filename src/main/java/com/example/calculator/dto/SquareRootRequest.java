package com.example.calculator.dto;

import javax.validation.constraints.NotNull;

public record SquareRootRequest(
        @NotNull(message = "number cannot be null")
        Double number
) {
}
