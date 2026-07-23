package com.example.__data_source.controllers;

import com.example.__data_source.models.Purchase;
import com.example.__data_source.services.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/")
    public ResponseEntity<Purchase> createPurchase(@Valid @RequestBody Purchase purchase) {
        // store the purchase
        purchaseService.storePurchase(purchase);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(purchase);
    }

    @GetMapping("/")
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(purchaseService.findAllPurchases());
    }
}
