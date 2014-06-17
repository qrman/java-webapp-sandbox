package pl.urman.sandbox.auth;

import pl.urman.sandbox.auth.annotation.UserLoggedIn;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class AuthModule extends AbstractModule {

    @Override
    protected void configure() {
        UserLoggedInInterceptor userLoggedInInterceptor = new UserLoggedInInterceptor();
        requestInjection(userLoggedInInterceptor);
        bindInterceptor(
            Matchers.annotatedWith(UserLoggedIn.class),
            Matchers.any(),
            userLoggedInInterceptor);
    }
}
