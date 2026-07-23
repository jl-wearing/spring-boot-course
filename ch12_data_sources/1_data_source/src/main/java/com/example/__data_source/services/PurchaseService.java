package com.example.__data_source.services;

import com.example.__data_source.models.Purchase;
import com.example.__data_source.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public void storePurchase(Purchase purchase) {
        purchaseRepository.createPurchase(purchase);
    }

    public List<Purchase> findAllPurchases(){
        return purchaseRepository.findAllPurchases();
    }
}
