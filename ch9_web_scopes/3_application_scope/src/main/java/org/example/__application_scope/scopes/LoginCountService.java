package org.example.__application_scope.scopes;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class LoginCountService {
    private int count;

    public void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
