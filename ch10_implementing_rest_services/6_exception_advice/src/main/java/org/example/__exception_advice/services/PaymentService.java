package org.example.__exception_advice.services;

import org.example.__exception_advice.exceptions.NotEnoughMoneyException;
import org.example.__exception_advice.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException("Not enough money");
    }
}
