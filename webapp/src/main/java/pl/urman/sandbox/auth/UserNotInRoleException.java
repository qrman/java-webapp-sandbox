package pl.urman.sandbox.auth;

import java.util.Set;
import lombok.Getter;
import pl.urman.sandbox.model.user.Role;

public class UserNotInRoleException extends Exception {

    @Getter
    private final Set<Role> roles;
    @Getter
    private final String message;

    public UserNotInRoleException(String message, Set<Role> roles) {
        this.message = message;
        this.roles = roles;
    }
}
