package pl.urman.sandbox.model.user;

import com.google.inject.Inject;
import org.junit.Ignore;
import org.junit.Test;
import pl.urman.sandbox.guice.SandboxIntegrationTest;

public class UserPersisterTest extends SandboxIntegrationTest {

    @Inject
    private UserPersister userPersister;

    @Test
    public void will_persist_new_user() {

        userPersister.deleteAll();

        userPersister.addUser(
                User.builder()
                .username("john").email("john@email.com")
                .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void will_throw_exception_when_tries_to_duplicate_username() {

    }

}
