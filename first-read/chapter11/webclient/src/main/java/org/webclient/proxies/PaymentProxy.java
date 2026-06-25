package org.webclient.proxies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.webclient.models.Payment;
import reactor.core.publisher.Mono;

@Component
public class PaymentProxy {
    private final WebClient webClient;

    @Autowired
    public PaymentProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    @Value("${name.service.url}")
    private String url;

    public Mono<Payment> createPayment(String requestId, Payment payment) {
        return webClient
                .post()
                .uri(url + "/payment")
                .header("requestId", requestId)
                .body(Mono.just(payment), Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);
    }
}
