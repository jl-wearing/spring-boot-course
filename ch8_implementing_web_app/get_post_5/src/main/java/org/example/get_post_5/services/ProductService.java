package org.example.get_post_5.services;

import org.example.get_post_5.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    // Represent some type of data storage for now.
    private static final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
