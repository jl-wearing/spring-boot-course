package org.example.__exception_handling.controllers;

import org.example.__exception_handling.exceptions.NotEnoughMoneyException;
import org.example.__exception_handling.models.ErrorDetails;
import org.example.__exception_handling.models.PaymentDetails;
import org.example.__exception_handling.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        }
        catch (NotEnoughMoneyException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorDetails.builder().message("Not enough money to make payment.").build());
        }
    }
}
