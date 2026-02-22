package org.scopes1.controllers;

import org.scopes1.services.LoggedUserManagementService;
import org.scopes1.services.LoginCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {
        // Unset the session if the user wants to log out.
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        // Only redirect to home page if user session is set.
        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();
        if (username == null) {
            return "redirect:/";
        }

        // Send the username to the view.
        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);
        return "main";
    }
}
