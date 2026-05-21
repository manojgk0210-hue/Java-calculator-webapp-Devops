package com.example.calculator.controller;

import com.example.calculator.exception.DivisionByZeroException;
import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void healthShouldReturnSuccessResponse() throws Exception {
        mockMvc.perform(get("/api/v1/calculator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.message").value("Calculator service is running"))
                .andExpect(jsonPath("$.result").value(1.0));
    }

    @Test
    void addShouldReturnSuccessResponse() throws Exception {
        when(calculatorService.add(10.0, 5.0)).thenReturn(15.0);

        mockMvc.perform(post("/api/v1/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "number1": 10,
                                  "number2": 5
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.message").value("Operation completed successfully"))
                .andExpect(jsonPath("$.result").value(15.0));
    }

    @Test
    void subtractShouldReturnSuccessResponse() throws Exception {
        when(calculatorService.subtract(10.0, 5.0)).thenReturn(5.0);

        mockMvc.perform(post("/api/v1/calculator/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validBinaryRequest()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.0));
    }

    @Test
    void multiplyShouldReturnSuccessResponse() throws Exception {
        when(calculatorService.multiply(10.0, 5.0)).thenReturn(50.0);

        mockMvc.perform(post("/api/v1/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validBinaryRequest()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(50.0));
    }

    @Test
    void divideShouldReturnBadRequestWhenDividingByZero() throws Exception {
        when(calculatorService.divide(anyDouble(), anyDouble()))
                .thenThrow(new DivisionByZeroException("Division by zero is not allowed"));

        mockMvc.perform(post("/api/v1/calculator/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "number1": 10,
                                  "number2": 0
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("ERROR"))
                .andExpect(jsonPath("$.message").value("Division by zero is not allowed"));
    }

    @Test
    void requestValidationShouldReturnBadRequestWhenNumber1IsNull() throws Exception {
        mockMvc.perform(post("/api/v1/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "number2": 5
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("ERROR"))
                .andExpect(jsonPath("$.message").value("Validation failed"))
                .andExpect(jsonPath("$.errors[0]", containsString("number1 cannot be null")));
    }

    @Test
    void squareRootShouldReturnSuccessResponse() throws Exception {
        when(calculatorService.squareRoot(16.0)).thenReturn(4.0);

        mockMvc.perform(post("/api/v1/calculator/sqrt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "number": 16
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(4.0));
    }

    private String validBinaryRequest() {
        return """
                {
                  "number1": 10,
                  "number2": 5
                }
                """;
    }
}
