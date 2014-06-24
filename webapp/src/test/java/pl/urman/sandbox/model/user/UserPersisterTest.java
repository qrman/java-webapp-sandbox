package pl.urman.sandbox.model.user;

import pl.urman.sandbox.db.model.Role;
import pl.urman.sandbox.db.ex.KeyViolationException;
import pl.urman.sandbox.guice.SandboxIntegrationTest;

import com.google.inject.Inject;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import org.junit.Test;

public class UserPersisterTest extends SandboxIntegrationTest {

    @Inject
    private UserPersister userPersister;

    @Inject
    private UserFinder userFinder;

    @Test
    public void will_persist_new_user() {

        //execute
        Long userId = userPersister.addUser(User.builder()
            .username("john")
            .email("john@email.com")
            .build());

        //check
        User actual = userFinder.findById(userId);
        assertThat("user was stored", actual.getUsername(), is(equalTo("john")));
        assertThat("user is in USER role", actual.getRoles(), Matchers.contains(Role.USER));

    }

    @Test(expected = KeyViolationException.class)
    public void will_throw_exception_when_tries_to_duplicate_username() {

        //prepare
        userPersister.addUser(User.builder()
            .username("john")
            .email("john@email.com")
            .build());

        //excute - expect to raise error
        userPersister.addUser(User.builder()
            .username("john")
            .email("other@email.com")
            .build());
    }
}
