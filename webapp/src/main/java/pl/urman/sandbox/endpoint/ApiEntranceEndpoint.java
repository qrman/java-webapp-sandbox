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

@Path("")
public class ApiEntranceEndpoint {

    @Inject
    private ApiUriBuilder uriBuilder;

    @Inject
    private WSUriBuilder wsUriBuilder;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, URI> entrance() {
        Map<String, URI> apiMap = new HashMap<>();

        apiMap.put("auth", uriBuilder.get().path(AuthEndpoint.class).build());
        apiMap.put("user", uriBuilder.get().path(UserEndpoint.class).build());
        apiMap.put("user-notify", wsUriBuilder.get().path("user-notify").build());

        return apiMap;
    }
}
