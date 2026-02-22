package org.spring2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }

    @RequestMapping("/about-us")
    public String aboutUs() {
        return "contact-us.html";
    }

    @RequestMapping("/products")
    public String products() {
        return "products.html";
    }
}
