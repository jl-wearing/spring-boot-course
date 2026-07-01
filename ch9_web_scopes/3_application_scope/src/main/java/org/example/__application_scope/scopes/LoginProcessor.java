package org.example.__application_scope.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private static final String correctUsername = "natalie";
    private static final String correctPassword = "password";

    private final LoginCountService loginCountService;
    private final LoggedUserManagementService loggedUserManagementService;
    private String password;
    private String username;

    @Autowired
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login() {
        loginCountService.increment();
        boolean isCorrect = correctUsername.equals(username) && correctPassword.equals(password);
        if (isCorrect) {
            // set the username session-scoped on correct password.
            loggedUserManagementService.setUsername(username);
            return true;
        }
        return false;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
