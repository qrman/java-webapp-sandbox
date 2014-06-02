package pl.urman.sandbox.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pl.urman.sandbox.auth.AuthService;
import pl.urman.sandbox.model.user.User;
import pl.urman.sandbox.model.user.UserFinder;
import pl.urman.sandbox.model.user.UserPersister;

@Path("/user")
public class UserEndpoint {

    @Inject
    private UserFinder userFinder;

    @Inject
    private UserPersister userPersister;

    @Inject
    private AuthService authService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAll() {

        if (authService.currentUser() == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok(userFinder.fetchAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User user) {
        userPersister.addUser(user);
    }

    @DELETE
    public Response deleteAll() {
        userPersister.deleteAll();
        return Response.ok().build();
    }
}
