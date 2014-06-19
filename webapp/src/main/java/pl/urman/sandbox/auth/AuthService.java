package pl.urman.sandbox.auth;

import com.google.inject.Provider;
import java.util.Optional;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import pl.urman.sandbox.model.user.Role;
import pl.urman.sandbox.model.user.User;
import pl.urman.sandbox.model.user.UserFinder;

public class AuthService {

    @Inject
    UserFinder userFinder;

    @Inject
    private Provider<HttpSession> sessionProvider;

    public Optional<User> currentUser() {
        HttpSession session = sessionProvider.get();
        Long userId = (Long) session.getAttribute("userId");

        return userId != null
                ? Optional.ofNullable(userFinder.findById(userId))
                : Optional.empty();
    }

    public Long currentUserId() {
        HttpSession session = sessionProvider.get();
        return (Long) session.getAttribute("userId");
    }

    public boolean authenticate(UserLoginRequest req) {
        HttpSession session = sessionProvider.get();
        Optional<User> user = userFinder.findByUsername(req.getUsername());

        if (user.isPresent()) {
            session.setAttribute("userId", user.get().getId());
            return true;
        }
        return false;
    }

    public void logout() {
        HttpSession session = sessionProvider.get();
        session.invalidate();
    }

    boolean userInAnyRole(Set<Role> roles) {
        Optional<User> currentUser = currentUser();
        if (!currentUser.isPresent()) {
            return false;
        }

        User user = currentUser.get();
        roles.retainAll(user.getRoles());

        return !roles.isEmpty();
    }
}
