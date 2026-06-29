package org.example.dynamic_view_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home(Model model) {
        // send data to the view.
        model.addAttribute("username", "laurentiu");
        model.addAttribute("color", "red");

        // return the view name.
        return "index";
    }
}
