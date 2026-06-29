package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/home/{username}/{color}")
    public String index(@PathVariable String username,
                        @PathVariable String color,
                        Model model) {
        // Send the username to the view.
        model.addAttribute("username", username);

        // Change the background color of the page.
        model.addAttribute("color", color);

        // return the view name.
        return "home";
    }
}
