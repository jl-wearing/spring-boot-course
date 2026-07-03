package org.example.__exception_handling.services;

import org.example.__exception_handling.exceptions.NotEnoughMoneyException;
import org.example.__exception_handling.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException("Not enough money");
    }
}
