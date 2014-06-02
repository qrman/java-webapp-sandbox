package pl.urman.sandbox.endpoint;

import com.google.inject.Provider;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import pl.urman.sandbox.auth.UserLoginRequest;

@Path("/auth")
public class AuthEndpoint {

    @Inject
    private Provider<HttpServletRequest> requestProvider;

    @POST
    public Response authenticate(UserLoginRequest loginRequest) {
        //TODO
        return Response.ok().build();
    }
}
