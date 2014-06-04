package pl.urman.sandbox.auth;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import pl.urman.sandbox.model.user.User;
import pl.urman.sandbox.model.user.UserFinder;

import com.google.inject.Provider;

public class AuthService {

    @Inject
    UserFinder userFinder;

    @Inject
    private Provider<HttpSession> sessionProvider;

    public User currentUser() {

        HttpSession session = sessionProvider.get();
        Long userId = (Long) session.getAttribute("userId");

        return userId != null ? userFinder.findById(userId) : null;
    }

    public boolean authenticate(UserLoginRequest req) {
        HttpSession session = sessionProvider.get();
        User user = userFinder.findByUsername(req.getUsername());

        if (user != null) {
            session.setAttribute("userId", user.getId());
            return true;
        }
        return false;
    }
}
