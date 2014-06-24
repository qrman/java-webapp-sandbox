package pl.urman.sandbox.model.user;

import pl.urman.sandbox.db.ex.KeyViolationException;
import pl.urman.sandbox.guice.SandboxIntegrationTest;

import com.google.inject.Inject;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

public class UserPersisterTest extends SandboxIntegrationTest {

    @Inject
    private UserPersister userPersister;

    @Inject
    private UserDeleter userDeleter;

    @Inject
    private UserFinder userFinder;

    @Before
    public void clearUsers() {
        userDeleter.deleteAll();
    }

    @Test
    public void will_persist_new_user() {

        //execute
        Long userId = userPersister.addUser(User.builder()
            .username("john")
            .email("john@email.com")
            .build());

        //check
        User actual = userFinder.findById(userId);
        MatcherAssert.assertThat("user was store", actual.getUsername(), is(equalTo("john")));

    }

    @Test(expected = KeyViolationException.class)
    public void will_throw_exception_when_tries_to_duplicate_username() {

        //prepare
        userPersister.addUser(User.builder()
            .username("john")
            .email("john@email.com")
            .build());

        //excute
        userPersister.addUser(User.builder()
            .username("john")
            .email("other@email.com")
            .build());
    }

}
