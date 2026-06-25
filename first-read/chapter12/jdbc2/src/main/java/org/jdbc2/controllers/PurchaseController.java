package org.jdbc2.controllers;

import org.jdbc2.models.Purchase;
import org.jdbc2.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping()
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.setPurchase(purchase);
    }

    @GetMapping()
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.getPurchases();
    }
}
