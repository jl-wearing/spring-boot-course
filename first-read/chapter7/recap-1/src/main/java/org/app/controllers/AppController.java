package org.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @RequestMapping("/home")
    public String home(Model page) {
        // Add the color to the page view.
        page.addAttribute("color", "red");

        // Send the username to the view.
        page.addAttribute("username", "Katy");

        // Return the name of the view.
        return "home";
    }

    @RequestMapping("/contact-us")
    public String contactUs(@RequestParam(required = false) String tel,
                            @RequestParam String addr,
                            Model page) {
        // Send the telephone number to the view.
        page.addAttribute("telephone", tel);

        // Send the address to the view.
        page.addAttribute("address", addr);

        // Return the name of the view.
        return "contact-us";
    }

    @RequestMapping("/about-us/{first}/{last}")
    public String aboutUs(@PathVariable String first,
                          @PathVariable String last,
                          Model page) {
        // Send the first name to the view.
        page.addAttribute("first", first);

        // Send the last name to the view.
        page.addAttribute("last", last);

        // Return the name of the view.
        return "about-us";
    }
}
