package org.rest3.services;

import org.rest3.exceptions.NotEnoughMoneyException;
import org.rest3.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
