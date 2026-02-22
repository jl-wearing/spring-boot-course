package org.payments.controllers;

import jakarta.annotation.PostConstruct;
import org.payments.models.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private static Logger logger;

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment,
                                                 @RequestHeader String requestId) {
        // Log the details of the payment.
        logger.info("Received request with ID: " + requestId
        + ", ;Payment Amount: " + payment.getAmount());

        // Assign the unique ID to the payment.
        payment.setId(requestId);

        // Return the HTTP response.
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(PaymentsController.class.getName());
    }
}
