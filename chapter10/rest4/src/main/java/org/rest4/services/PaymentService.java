package org.rest4.services;

import org.rest4.exceptions.NotEnoughMoneyException;
import org.rest4.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
