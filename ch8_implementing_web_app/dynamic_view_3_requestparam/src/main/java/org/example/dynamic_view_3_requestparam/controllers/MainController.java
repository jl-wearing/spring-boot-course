package org.example.dynamic_view_3_requestparam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home(@RequestParam(defaultValue = "pink") String color, Model model) {
        // change the color of the background.
        model.addAttribute("color", color);

        // Add a welcome message to the view.
        model.addAttribute("greeting", "Welcome to my site!");

        // return the view name.
        return "home";
    }
}
