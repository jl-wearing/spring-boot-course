package org.reinforcement.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.reinforcement.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList;

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> findAll() {
        return productList;
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<Product>();
    }
}
