package pl.urman.sandbox.auth;

import javax.inject.Inject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class UserLoggedInInterceptor implements MethodInterceptor {

    @Inject
    private AuthService authService;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (authService.currentUserId() == null) {
            throw new UserNotAuthorizedException("User should be logged in");
        }
        return invocation.proceed();
    }
}
