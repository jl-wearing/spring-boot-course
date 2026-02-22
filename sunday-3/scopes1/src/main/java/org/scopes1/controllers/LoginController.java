package org.scopes1.controllers;

import org.scopes1.models.LoginProcessor;
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
    public String getLogin(){
        return "login";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        // Send the credentials to the processor for validation.
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        // Determine if the credentials are correct.
        boolean loggedIn = loginProcessor.login();

        // Send the right message to the view depending on if the credentials are correct.
        model.addAttribute("message", loggedIn ? "You are now logged in." : "Login failed!");

        // Return the name of the view.
        return "login";
    }
}
