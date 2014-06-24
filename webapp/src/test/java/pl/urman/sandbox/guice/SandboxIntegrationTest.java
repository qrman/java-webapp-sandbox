
package pl.urman.sandbox.guice;

import pl.urman.sandbox.db.guice.TestDbModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;

public class SandboxIntegrationTest {

    @Before
    public void prepareEnvironment() {
        Injector injector = Guice.createInjector(
                new TestDbModule());
        injector.injectMembers(this);
    }
}
