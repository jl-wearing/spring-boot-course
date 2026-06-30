package org.example.__session_scope.controllers;

import org.example.__session_scope.scopes.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {
        String username = loggedUserManagementService.getUsername();

        // log the user out if the user clicks the logout link.
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
            return "redirect:/";
        }

        if (username == null) {
            return "redirect:/";
        }
        // send the username to the model.
        model.addAttribute("username", username);

        return "main";
    }
}
