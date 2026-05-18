package com.example.calculator.dto;

import javax.validation.constraints.NotNull;

public record CalculatorRequest(
        @NotNull(message = "number1 cannot be null")
        Double number1,

        @NotNull(message = "number2 cannot be null")
        Double number2
) {
}
