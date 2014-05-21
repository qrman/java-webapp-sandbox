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

@Path("")
public class ApiEntranceEndpoint {

    @Inject
    private ApiUriBuilder uriBuilder;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, URI> entrance() {
        Map<String, URI> apiMap = new HashMap<>();

        apiMap.put("user", uriBuilder.get().path(UserEndpoint.class).build());

        return apiMap;
    }
}
