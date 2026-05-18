package com.example.calculator.controller;

import com.example.calculator.dto.CalculatorRequest;
import com.example.calculator.dto.CalculatorResponse;
import com.example.calculator.dto.SquareRootRequest;
import com.example.calculator.service.CalculatorService;
import com.example.calculator.util.ResponseBuilder;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    private static final Logger log = LoggerFactory.getLogger(CalculatorController.class);

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public ResponseEntity<CalculatorResponse> health() {
        log.info("Calculator health check requested");
        return ResponseEntity.ok(ResponseBuilder.success(1.0, "Calculator service is running"));
    }

    @PostMapping("/add")
    public ResponseEntity<CalculatorResponse> add(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.add(request.number1(), request.number2());
        return ResponseEntity.ok(ResponseBuilder.success(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculatorResponse> subtract(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.subtract(request.number1(), request.number2());
        return ResponseEntity.ok(ResponseBuilder.success(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculatorResponse> multiply(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.multiply(request.number1(), request.number2());
        return ResponseEntity.ok(ResponseBuilder.success(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculatorResponse> divide(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.divide(request.number1(), request.number2());
        return ResponseEntity.ok(ResponseBuilder.success(result));
    }

    @PostMapping("/modulus")
    public ResponseEntity<CalculatorResponse> modulus(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.modulus(request.number1(), request.number2());
        return ResponseEntity.ok(ResponseBuilder.success(result));
    }

    @PostMapping("/power")
    public ResponseEntity<CalculatorResponse> power(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.power(request.number1(), request.number2());
        return ResponseEntity.ok(ResponseBuilder.success(result));
    }

    @PostMapping("/sqrt")
    public ResponseEntity<CalculatorResponse> squareRoot(@Valid @RequestBody SquareRootRequest request) {
        double result = calculatorService.squareRoot(request.number());
        return ResponseEntity.ok(ResponseBuilder.success(result));
    }
}
