package pl.urman.sandbox.auth;

import pl.urman.sandbox.auth.annotation.RolesAllowed;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class AuthModule extends AbstractModule {

    @Override
    protected void configure() {
        RolesAllowedInterceptor userLoggedInInterceptor = new RolesAllowedInterceptor();
        requestInjection(userLoggedInInterceptor);
        bindInterceptor(
            Matchers.annotatedWith(RolesAllowed.class),
            Matchers.any(),
            userLoggedInInterceptor);
    }
}
