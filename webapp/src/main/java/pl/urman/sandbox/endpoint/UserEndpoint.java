package pl.urman.sandbox.endpoint;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.urman.sandbox.model.user.User;
import pl.urman.sandbox.model.user.UserFinder;
import pl.urman.sandbox.model.user.UserPersister;

@Path("user")
public class UserEndpoint {

    @Inject
    private UserFinder userFinder;

    @Inject
    private UserPersister userPersister;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> fetchAll() {
        return userFinder.fetchAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User user) {
        userPersister.addUser(user);
    }
}
