package com.example.calculator.util;

import com.example.calculator.dto.CalculatorResponse;

import java.time.LocalDateTime;

public final class ResponseBuilder {

    private ResponseBuilder() {
    }

    public static CalculatorResponse success(double result) {
        return success(result, CalculatorConstants.DEFAULT_SUCCESS_MESSAGE);
    }

    public static CalculatorResponse success(double result, String message) {
        return new CalculatorResponse(
                CalculatorConstants.SUCCESS_STATUS,
                message,
                result,
                LocalDateTime.now()
        );
    }
}
