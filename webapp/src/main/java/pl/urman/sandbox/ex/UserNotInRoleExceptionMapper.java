package pl.urman.sandbox.ex;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import pl.urman.sandbox.auth.UserNotInRoleException;
import pl.urman.sandbox.model.user.Role;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
@Provider
public class UserNotInRoleExceptionMapper implements ExceptionMapper<UserNotInRoleException> {

    @Override
    public Response toResponse(UserNotInRoleException e) {
        if (e.getRoles().contains(Role.USER)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();

    }
}
