package org.resttemplate.proxies;

import org.resttemplate.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentsProxy {
    private final RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String paymentsServiceUrl;

    @Autowired
    public PaymentsProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment) {
        // Define the request URI
        String uri = paymentsServiceUrl + "/payment";

        // Define the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        // Bind the headers and body to the HTTP request.
        HttpEntity<Payment> request = new HttpEntity<>(payment, headers);

        // Define the HTTP request sent to the REST endpoint, and also the HTTP response expected.
        ResponseEntity<Payment> response =
                restTemplate.exchange(uri, HttpMethod.POST, request, Payment.class);

        // Exchange data between client and server.
        return response.getBody();
    }
}
