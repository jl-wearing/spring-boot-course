package com.example.__spring_data.handlers;

import com.example.__spring_data.exceptions.AccountNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AccountExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleAccountNotFoundException(AccountNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, String>> handleDataAccessException(DataAccessException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
