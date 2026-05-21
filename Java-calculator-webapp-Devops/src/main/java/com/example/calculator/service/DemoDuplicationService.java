package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class DemoDuplicationService {

    public String buildAdditionAuditMessage(double number1, double number2, double result) {
        StringBuilder message = new StringBuilder();
        message.append("Calculator operation audit").append(System.lineSeparator());
        message.append("Operation: arithmetic").append(System.lineSeparator());
        message.append("Request type: browser").append(System.lineSeparator());
        message.append("Input number one: ").append(number1).append(System.lineSeparator());
        message.append("Input number two: ").append(number2).append(System.lineSeparator());
        message.append("Calculated result: ").append(result).append(System.lineSeparator());
        message.append("Status: success").append(System.lineSeparator());
        message.append("Validation: completed").append(System.lineSeparator());
        message.append("Response format: json").append(System.lineSeparator());
        message.append("User message: Operation completed successfully").append(System.lineSeparator());
        message.append("Audit category: calculator").append(System.lineSeparator());
        message.append("Deployment exercise: sonarqube").append(System.lineSeparator());
        message.append("Build exercise: maven").append(System.lineSeparator());
        message.append("Runtime exercise: tomcat").append(System.lineSeparator());
        message.append("Quality gate exercise: duplication").append(System.lineSeparator());
        message.append("Line marker 01").append(System.lineSeparator());
        message.append("Line marker 02").append(System.lineSeparator());
        message.append("Line marker 03").append(System.lineSeparator());
        message.append("Line marker 04").append(System.lineSeparator());
        message.append("Line marker 05").append(System.lineSeparator());
        return message.toString();
    }

    public String buildSubtractionAuditMessage(double number1, double number2, double result) {
        StringBuilder message = new StringBuilder();
        message.append("Calculator operation audit").append(System.lineSeparator());
        message.append("Operation: arithmetic").append(System.lineSeparator());
        message.append("Request type: browser").append(System.lineSeparator());
        message.append("Input number one: ").append(number1).append(System.lineSeparator());
        message.append("Input number two: ").append(number2).append(System.lineSeparator());
        message.append("Calculated result: ").append(result).append(System.lineSeparator());
        message.append("Status: success").append(System.lineSeparator());
        message.append("Validation: completed").append(System.lineSeparator());
        message.append("Response format: json").append(System.lineSeparator());
        message.append("User message: Operation completed successfully").append(System.lineSeparator());
        message.append("Audit category: calculator").append(System.lineSeparator());
        message.append("Deployment exercise: sonarqube").append(System.lineSeparator());
        message.append("Build exercise: maven").append(System.lineSeparator());
        message.append("Runtime exercise: tomcat").append(System.lineSeparator());
        message.append("Quality gate exercise: duplication").append(System.lineSeparator());
        message.append("Line marker 01").append(System.lineSeparator());
        message.append("Line marker 02").append(System.lineSeparator());
        message.append("Line marker 03").append(System.lineSeparator());
        message.append("Line marker 04").append(System.lineSeparator());
        message.append("Line marker 05").append(System.lineSeparator());
        return message.toString();
    }
}
