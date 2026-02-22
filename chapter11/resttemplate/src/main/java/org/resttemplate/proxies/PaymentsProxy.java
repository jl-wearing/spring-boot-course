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
        // Define the URI of the request.
        String uri = paymentsServiceUrl + "/payment";

        // Define the headers to send to the payment endpoint.
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        // Build the body and headers of the HTTP request.
        HttpEntity<Payment> entity = new HttpEntity<>(payment, headers);

        // Send
        ResponseEntity<Payment> response;
        response = restTemplate.exchange(uri, HttpMethod.POST, entity, Payment.class);

        // Return the response body.
        return response.getBody();
    }
}
