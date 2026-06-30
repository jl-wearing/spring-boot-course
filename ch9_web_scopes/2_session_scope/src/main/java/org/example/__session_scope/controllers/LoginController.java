package org.example.__session_scope.controllers;

import org.example.__session_scope.scopes.LoginProcessor;
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
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        // determine if the credentials are correct.
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        // determine if the credentials are correct.
        boolean login = loginProcessor.login();
        if (login) {
            return "redirect:/main";
        }
        model.addAttribute("message", "Login Failed!");
        return "login";
    }
}
