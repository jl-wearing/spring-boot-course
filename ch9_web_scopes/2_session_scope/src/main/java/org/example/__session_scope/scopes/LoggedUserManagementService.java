package org.example.__session_scope.scopes;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUserManagementService {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
}
