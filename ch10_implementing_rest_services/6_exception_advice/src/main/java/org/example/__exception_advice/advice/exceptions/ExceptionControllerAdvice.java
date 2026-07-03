package org.example.__exception_advice.advice.exceptions;

import org.example.__exception_advice.exceptions.NotEnoughMoneyException;
import org.example.__exception_advice.models.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoney() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDetails("Not enough money"));
    }
}
