package com.example.calculator.service;

public interface CalculatorService {

    double add(double number1, double number2);

    double subtract(double number1, double number2);

    double multiply(double number1, double number2);

    double divide(double number1, double number2);

    double modulus(double number1, double number2);

    double power(double base, double exponent);

    double squareRoot(double number);
}
