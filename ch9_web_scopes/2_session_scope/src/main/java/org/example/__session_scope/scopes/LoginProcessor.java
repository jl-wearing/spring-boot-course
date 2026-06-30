package org.example.__session_scope.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private static final String correctUsername = "natalie";
    private static final String correctPassword = "password";

    private String username;
    private String password;

    private final LoggedUserManagementService loggedUserManagementService;

    @Autowired
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean login() {
        boolean loggedIn = correctPassword.equals(password) && correctUsername.equals(username);

        if (loggedIn) {
            loggedUserManagementService.setUsername(username);
            return true;
        }
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
