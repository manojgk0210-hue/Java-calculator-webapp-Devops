package com.example.calculator.service;

import com.example.calculator.exception.DivisionByZeroException;
import com.example.calculator.exception.InvalidCalculatorInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceImplTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void addShouldReturnSum() {
        assertEquals(15.0, calculatorService.add(10.0, 5.0));
    }

    @Test
    void subtractShouldReturnDifference() {
        assertEquals(5.0, calculatorService.subtract(10.0, 5.0));
    }

    @Test
    void multiplyShouldReturnProduct() {
        assertEquals(50.0, calculatorService.multiply(10.0, 5.0));
    }

    @Test
    void divideShouldReturnQuotient() {
        assertEquals(2.0, calculatorService.divide(10.0, 5.0));
    }

    @Test
    void divideShouldThrowExceptionWhenDivisorIsZero() {
        assertThrows(DivisionByZeroException.class, () -> calculatorService.divide(10.0, 0.0));
    }

    @Test
    void modulusShouldReturnRemainder() {
        assertEquals(1.0, calculatorService.modulus(11.0, 5.0));
    }

    @Test
    void modulusShouldThrowExceptionWhenDivisorIsZero() {
        assertThrows(DivisionByZeroException.class, () -> calculatorService.modulus(10.0, 0.0));
    }

    @Test
    void powerShouldReturnPowerValue() {
        assertEquals(100.0, calculatorService.power(10.0, 2.0));
    }

    @Test
    void squareRootShouldReturnSquareRootValue() {
        assertEquals(4.0, calculatorService.squareRoot(16.0));
    }

    @Test
    void squareRootShouldThrowExceptionForNegativeNumber() {
        assertThrows(InvalidCalculatorInputException.class, () -> calculatorService.squareRoot(-16.0));
    }
}
