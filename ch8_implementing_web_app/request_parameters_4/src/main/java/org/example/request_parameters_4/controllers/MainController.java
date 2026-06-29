package org.example.request_parameters_4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home(@RequestParam(defaultValue = "white") String color,
                       @RequestParam(defaultValue = "User") String name,
                       Model model) {
        // change the background color of the page.
        model.addAttribute("color", color);

        // Send the username to the view.
        model.addAttribute("name", name);

        // return the view name.
        return "home";
    }
}
