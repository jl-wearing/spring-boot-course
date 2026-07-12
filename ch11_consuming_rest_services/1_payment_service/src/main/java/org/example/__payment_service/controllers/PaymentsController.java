package org.example.__payment_service.controllers;

import org.example.__payment_service.models.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private static final Logger LOGGER = Logger.getLogger(PaymentsController.class.getName());

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId,
                                                 @RequestBody Payment payment) {
        LOGGER.info("payment received with id: " + requestId + ", with payment: " + payment.getAmount());

        // Add a unique ID for this payment.
        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(payment);
    }
}
