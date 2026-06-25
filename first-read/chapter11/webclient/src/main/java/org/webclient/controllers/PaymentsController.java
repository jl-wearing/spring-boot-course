package org.webclient.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.webclient.models.Payment;
import org.webclient.proxies.PaymentProxy;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class PaymentsController {
    private final PaymentProxy paymentProxy;

    public PaymentsController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        // Create a random ID for the payment.
        String requestId = UUID.randomUUID().toString();

        // Send the HTTP headers and HTTP body to the REST endpoint.
        return paymentProxy.createPayment(requestId, payment);
    }
}
