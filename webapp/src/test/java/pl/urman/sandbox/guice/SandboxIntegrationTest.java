package pl.urman.sandbox.guice;

import pl.urman.sandbox.db.DBCleaner;
import pl.urman.sandbox.db.guice.DbMode;
import pl.urman.sandbox.db.guice.DbModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Before;

public class SandboxIntegrationTest {

    @Inject
    private DBCleaner dBCleaner;

    @Before
    public void prepareEnvironment() {
        Injector injector = Guice.createInjector(
            new DbModule(DbMode.TEST));
        injector.injectMembers(this);
    }

    @After
    public void clearDB() {
        dBCleaner.apply();
    }
}
