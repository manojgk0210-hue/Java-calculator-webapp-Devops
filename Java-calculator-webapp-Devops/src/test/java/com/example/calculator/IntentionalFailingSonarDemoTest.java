package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntentionalFailingSonarDemoTest {

    @Test
    void demoFailureOneShouldShowWrongAdditionExpectation() {
        assertEquals(20, 10 + 5);
    }

    @Test
    void demoFailureTwoShouldShowWrongSubtractionExpectation() {
        assertEquals(1, 10 - 5);
    }

    @Test
    void demoFailureThreeShouldShowWrongMultiplicationExpectation() {
        assertEquals(40, 10 * 5);
    }

    @Test
    void demoFailureFourShouldShowWrongDivisionExpectation() {
        assertEquals(5, 10 / 5);
    }

    @Test
    void demoFailureFiveShouldShowWrongModulusExpectation() {
        assertEquals(0, 11 % 5);
    }

    @Test
    void demoFailureSixShouldShowWrongPowerExpectation() {
        assertEquals(100, Math.pow(2, 8));
    }
}
