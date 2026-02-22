package org.productsapp.controllers;

import org.productsapp.models.Product;
import org.productsapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "products";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model) {

        // Define a product to be added.
        var product = new Product();
        product.setName(name);
        product.setPrice(price);

        // Add the product to the list of products.
        productService.addProduct(product);

        // Send the data to the view for rendering.
        return "redirect:/products";
    }
}
