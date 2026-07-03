package org.example.__exception_advice.controllers;

import org.example.__exception_advice.models.PaymentDetails;
import org.example.__exception_advice.services.PaymentService;
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

    @PostMapping("/payments")
    public ResponseEntity<PaymentDetails> makePayment() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentService.processPayment());
    }
}
