package com.example.__spring_data.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
