package org.example.get_post_5.controllers;

import org.example.get_post_5.models.Product;
import org.example.get_post_5.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        // add the products to the view.
        model.addAttribute("products", productService.getProducts());

        // add a new product to the view.
        model.addAttribute("product", new Product());

        // return the view name.
        return "index";
    }

    @PostMapping("/")
    public String addProduct(@ModelAttribute Product product) {
        // add a new product to the list of products.
        productService.addProduct(product);

        // reload the home page.
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Product product) {
        // delete the product from the list of products.
        productService.removeProduct(product);

        // reload the home page.
        return "redirect:/";
    }
}
