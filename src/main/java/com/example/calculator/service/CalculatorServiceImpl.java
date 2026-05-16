package com.example.calculator.service;

import com.example.calculator.exception.DivisionByZeroException;
import com.example.calculator.exception.InvalidCalculatorInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServiceImpl.class);

    @Override
    public double add(double number1, double number2) {
        log.debug("Adding {} and {}", number1, number2);
        return number1 + number2;
    }

    @Override
    public double subtract(double number1, double number2) {
        log.debug("Subtracting {} from {}", number2, number1);
        return number1 - number2;
    }

    @Override
    public double multiply(double number1, double number2) {
        log.debug("Multiplying {} and {}", number1, number2);
        return number1 * number2;
    }

    @Override
    public double divide(double number1, double number2) {
        validateNonZeroDivisor(number2, "Division by zero is not allowed");
        log.debug("Dividing {} by {}", number1, number2);
        return number1 / number2;
    }

    @Override
    public double modulus(double number1, double number2) {
        validateNonZeroDivisor(number2, "Modulus by zero is not allowed");
        log.debug("Calculating modulus of {} by {}", number1, number2);
        return number1 % number2;
    }

    @Override
    public double power(double base, double exponent) {
        log.debug("Calculating {} raised to {}", base, exponent);
        return Math.pow(base, exponent);
    }

    @Override
    public double squareRoot(double number) {
        if (number < 0) {
            throw new InvalidCalculatorInputException("Square root does not accept negative numbers");
        }

        log.debug("Calculating square root of {}", number);
        return Math.sqrt(number);
    }

    private void validateNonZeroDivisor(double divisor, String message) {
        if (Double.compare(divisor, 0.0D) == 0) {
            throw new DivisionByZeroException(message);
        }
    }
}
