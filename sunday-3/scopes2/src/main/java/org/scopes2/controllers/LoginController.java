package org.scopes2.controllers;

import org.scopes2.models.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    @Autowired
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        // Determine if the credentials are correct.
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean correctCredentials = loginProcessor.login();

        // Display a different message depending on whether the credentials are correct or not.
        model.addAttribute("message", correctCredentials ? "You are now logged in." : "Incorrect credentials!");

        // Return the name of the view.
        return "login";
    }
}
