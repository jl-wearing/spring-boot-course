package org.example.__request_body.controllers;

import org.example.__request_body.models.PaymentDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private static final Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payments")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails){
        logger.info("Received amount: " + paymentDetails.amount());

        return ResponseEntity
                .ok()
                .body(paymentDetails);
    }
}
