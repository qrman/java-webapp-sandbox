package pl.urman.sandbox.auth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import pl.urman.sandbox.auth.annotation.RolesAllowed;
import pl.urman.sandbox.db.model.Role;

/**
 *
 * This class checks whether user is in any of defined role
 */
public class RolesAllowedInterceptor implements MethodInterceptor {

    @Inject
    private AuthService authService;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        RolesAllowed methodAnnotation = invocation.getMethod().getAnnotation(RolesAllowed.class);
        RolesAllowed classAnnotations = invocation.getThis().getClass().getAnnotation(RolesAllowed.class);

        Set<Role> roles = new HashSet<>();
        if (methodAnnotation != null) {
            roles.addAll(Arrays.asList(methodAnnotation.roles()));
        }
        if (classAnnotations != null) {
            roles.addAll(Arrays.asList(classAnnotations.roles()));
        }

        if (!authService.userInAnyRole(roles)) {
            throw new UserNotInRoleException("User should be in one of defined roles", roles);
        }

        return invocation.proceed();
    }
}
