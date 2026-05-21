package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class SonarIssueDemoService {

    public boolean hasDemoAccess(String userName) {
        String allowedUser = null;
        return allowedUser.equals(userName);
    }

    public void printDemoMessage(String message) {
        System.out.println("Sonar demo message: " + message);
    }

    private String buildUnusedDemoLabel(String value) {
        return "Unused Sonar demo label: " + value;
    }
}
