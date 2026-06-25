package org.productsapp.services;

import jakarta.annotation.PostConstruct;
import org.productsapp.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products;

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
    }
}
