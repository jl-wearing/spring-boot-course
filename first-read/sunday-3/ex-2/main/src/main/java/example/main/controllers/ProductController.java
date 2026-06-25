package example.main.controllers;

import example.main.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import example.main.services.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProduct(Model model) {
        // Send the products to the view.
        model.addAttribute("products", productService.findAll());

        // Return the name of the view.
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product product) {

        // Add the product to the list of products.
        productService.addProduct(product);

        // Return the name of the view.
        return "redirect:/products";
    }
}
