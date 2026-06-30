package org.example.__request_scope.controllers;

import org.example.__request_scope.login.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private LoginProcessor loginProcessor;

    @Autowired
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        // return the view name.
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        // Define the details of the login.
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        // Determine if the credentials are correct.
        boolean loggedIn = loginProcessor.login();
        model.addAttribute("loggedIn", loggedIn);

        if (loggedIn)
            model.addAttribute("message", "You are now logged in.");
        else
            model.addAttribute("message", "Login failed.");

        // return the view name.
        return "login";
    }
}
