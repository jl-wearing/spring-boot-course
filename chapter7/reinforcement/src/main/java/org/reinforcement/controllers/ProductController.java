package org.reinforcement.controllers;

import org.reinforcement.models.Product;
import org.reinforcement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        // Send the list of products to the view.
        var products = productService.findAll();
        model.addAttribute("products", products);

        // Return the name of the view.
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }
}
