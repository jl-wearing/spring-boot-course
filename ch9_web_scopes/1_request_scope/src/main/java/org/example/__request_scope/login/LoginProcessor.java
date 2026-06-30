package org.example.__request_scope.login;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private static final String correctUsername = "natalie";
    private static final String correctPassword = "password";
    private static int counter = 0;

    // instance variables.
    private String username;
    private String password;

    // Testing if a new instance is created for every http request.
    public LoginProcessor() {
        System.out.println("LoginProcessor constructor" + counter++);
    }

    public boolean login() {
        return correctPassword.equals(password) && username.equals(correctUsername);
    }

    // setters and getters.
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
}
