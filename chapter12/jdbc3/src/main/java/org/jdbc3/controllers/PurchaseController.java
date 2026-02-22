package org.jdbc3.controllers;

import org.jdbc3.models.Purchase;
import org.jdbc3.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PurchaseController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        paymentRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> getPurchases() {
        return paymentRepository.findAllPurchases();
    }
}
