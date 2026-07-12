package org.example.__openfeign.controllers;

import org.example.__openfeign.models.Payment;
import org.example.__openfeign.proxies.PaymentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private static final Logger logger = Logger.getLogger(PaymentsController.class.getName());
    private final PaymentsProxy paymentsProxy;

    @Autowired
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();

        logger.info("Creating Payment with id " + requestId + " for payment " + payment.getAmount());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paymentsProxy.createPayment(requestId, payment));
    }
}
