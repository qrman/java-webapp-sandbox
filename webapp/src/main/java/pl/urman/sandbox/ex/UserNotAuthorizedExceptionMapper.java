package pl.urman.sandbox.ex;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import pl.urman.sandbox.auth.UserNotAuthorizedException;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
@Provider
public class UserNotAuthorizedExceptionMapper implements ExceptionMapper<UserNotAuthorizedException>{

    @Override
    public Response toResponse(UserNotAuthorizedException e) {
        return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
    }
}
