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
    public String loginGet() {
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        // Determine if the credentials are correct.
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean correctCredentials = loginProcessor.login();

        // Redirect to main only if credentials are valid.
        if (correctCredentials) {
            return "redirect:/main";
        }

        model.addAttribute("message", "Login Unsuccessful!");

        // Return the view name.
        return "login";
    }
}
