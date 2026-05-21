package com.example.calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DemoDuplicationServiceTest {

    private final DemoDuplicationService demoDuplicationService = new DemoDuplicationService();

    @Test
    void buildAdditionAuditMessageShouldReturnAuditText() {
        String message = demoDuplicationService.buildAdditionAuditMessage(10, 5, 15);

        assertThat(message)
                .contains("Calculator operation audit")
                .contains("Quality gate exercise: duplication")
                .contains("Calculated result: 15.0");
    }
}
