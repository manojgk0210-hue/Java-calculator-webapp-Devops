package com.example.calculator.exception;

public class InvalidCalculatorInputException extends RuntimeException {

    public InvalidCalculatorInputException(String message) {
        super(message);
    }
}
