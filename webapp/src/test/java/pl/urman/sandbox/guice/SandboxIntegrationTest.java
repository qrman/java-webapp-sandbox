
package pl.urman.sandbox.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import pl.urman.sandbox.db.guice.DbModule;

public class SandboxIntegrationTest {

    @Before
    public void prepareEnvironment() {
        Injector injector = Guice.createInjector(
                new DbModule());
        injector.injectMembers(this);
    }
}
