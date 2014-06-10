package pl.urman.sandbox.endpoint;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.urman.sandbox.ApiUriBuilder;
import pl.urman.sandbox.WSUriBuilder;
import pl.urman.sandbox.auth.UserLoginRequest;

@Path("")
public class ApiEntranceEndpoint {

    @Inject
    private ApiUriBuilder uriBuilder;

    @Inject
    private WSUriBuilder wsUriBuilder;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, URI> entrance() throws NoSuchMethodException {
        Map<String, URI> apiMap = new HashMap<>();

        apiMap.put("login", uriBuilder.get()
            .path(AuthEndpoint.class)
            .path(AuthEndpoint.class.getMethod("login", UserLoginRequest.class)).build());
        apiMap.put("logout", uriBuilder.get()
            .path(AuthEndpoint.class)
            .path(AuthEndpoint.class.getMethod("logout", null)).build());
        apiMap.put("user", uriBuilder.get().path(UserEndpoint.class).build());
        apiMap.put("user-notify", wsUriBuilder.get().path("user-notify").build());

        return apiMap;
    }
}
