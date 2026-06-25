package org.scopes1.models;

import org.scopes1.services.LoggedUserManagementService;
import org.scopes1.services.LoginCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    @Autowired
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
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

    public boolean login() {
        // Increment the counter for each login attempt.
        loginCountService.increment();

        // Create a session for this user upon successful login.
        boolean loggedIn = false;
        if ("justin".equals(username.trim()) && "password".equals(password.trim())) {
            loggedUserManagementService.setUsername(username);
            loggedIn = true;
        }
        return loggedIn;
    }
}
