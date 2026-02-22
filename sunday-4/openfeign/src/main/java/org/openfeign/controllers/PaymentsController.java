package org.openfeign.controllers;

import org.openfeign.models.Payment;
import org.openfeign.proxies.PaymentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    @Autowired
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        // Define a unique ID for this payment.
        String requestId = UUID.randomUUID().toString();

        // Send the HTTP request to the payment endpoint.
        return paymentsProxy.createPayment(requestId, payment);
    }
}
