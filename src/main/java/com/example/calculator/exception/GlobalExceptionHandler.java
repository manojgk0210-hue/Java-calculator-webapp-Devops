package com.example.calculator.exception;

import com.example.calculator.dto.ErrorResponse;
import com.example.calculator.util.CalculatorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<ErrorResponse> handleDivisionByZeroException(DivisionByZeroException exception) {
        log.warn("Invalid arithmetic operation: {}", exception.getMessage());
        return buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), List.of(exception.getMessage()));
    }

    @ExceptionHandler(InvalidCalculatorInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCalculatorInputException(InvalidCalculatorInputException exception) {
        log.warn("Invalid calculator input: {}", exception.getMessage());
        return buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), List.of(exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .toList();

        log.warn("Request validation failed: {}", errors);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Validation failed", errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleMalformedJsonException(HttpMessageNotReadableException exception) {
        log.warn("Malformed request payload: {}", exception.getMessage());
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Malformed JSON request", List.of("Request body is invalid or missing"));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFoundException(NoResourceFoundException exception) {
        log.warn("Resource not found: {}", exception.getResourcePath());
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Resource not found", List.of(exception.getResourcePath()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
        log.error("Unexpected application error", exception);
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred",
                List.of("Please contact support if the issue persists")
        );
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String message, List<String> errors) {
        ErrorResponse response = new ErrorResponse(
                CalculatorConstants.ERROR_STATUS,
                message,
                errors,
                LocalDateTime.now()
        );

        return ResponseEntity.status(status).body(response);
    }
}
