package com.example.calculator.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void rootEndpointShouldReturnCalculatorPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/index.html"));
    }

    @Test
    void indexPageShouldContainCalculatorUi() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Calculator Web Application")))
                .andExpect(content().string(containsString("calculator-form")));
    }

    @Test
    void healthEndpointShouldReturnApplicationStatus() throws Exception {
        mockMvc.perform(get("/api/v1/calculator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.message").value("Calculator service is running"));
    }

    @Test
    void powerEndpointShouldCalculatePower() throws Exception {
        mockMvc.perform(post("/api/v1/calculator/power")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "number1": 2,
                                  "number2": 8
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(256.0));
    }

    @Test
    void squareRootEndpointShouldRejectNegativeNumbers() throws Exception {
        mockMvc.perform(post("/api/v1/calculator/sqrt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "number": -9
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("ERROR"))
                .andExpect(jsonPath("$.message").value("Square root does not accept negative numbers"));
    }

    @Test
    void divideEndpointShouldRejectZeroDivisor() throws Exception {
        mockMvc.perform(post("/api/v1/calculator/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "number1": 10,
                                  "number2": 0
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Division by zero is not allowed"));
    }

    @Test
    void addEndpointShouldRejectMissingNumber2() throws Exception {
        mockMvc.perform(post("/api/v1/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "number1": 10
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0]", containsString("number2 cannot be null")));
    }

    @Test
    void unknownPathShouldReturnNotFound() throws Exception {
        mockMvc.perform(get("/missing"))
                .andExpect(status().isNotFound());
    }
}
