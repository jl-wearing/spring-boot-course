package org.example.dynamic_view_2_cart.controllers;

import org.example.dynamic_view_2_cart.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model) {
        // Send data to the view.
        model.addAttribute("greeting", "Welcome to my shopping site!");

        // return the view name.
        return "home";
    }

    @RequestMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("pepsi", new BigDecimal("5.99")));
        products.add(new Product("coke", new BigDecimal("2.99")));
        products.add(new Product("cheese", new BigDecimal("25.99")));
        products.add(new Product("tomatoes", new BigDecimal("25.99")));

        // Send the product data to the view.
        model.addAttribute("products", products);

        // return the view name.
        return "products";
    }
}
