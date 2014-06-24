package pl.urman.sandbox.db.guice;

import java.util.Properties;

import javax.sql.DataSource;

import pl.urman.sandbox.db.DataSourceProvider;
import pl.urman.sandbox.db.JooqProvider;
import pl.urman.sandbox.db.PropertiesProvider;
import pl.urman.sandbox.db.TestPropertiesProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.jooq.DSLContext;

public class DbModule extends AbstractModule {

    private final DbMode mode;

    public DbModule(DbMode mode) {
        this.mode = mode;
    }

    @Override
    protected void configure() {
        if (mode.equals(DbMode.MAIN)) {
            bind(Properties.class).toProvider(PropertiesProvider.class);
        }
        if (mode.equals(DbMode.TEST)) {
            bind(Properties.class).toProvider(TestPropertiesProvider.class);
        }

        bind(DataSource.class).toProvider(DataSourceProvider.class);
        bind(DSLContext.class).toProvider(JooqProvider.class).in(Singleton.class);
    }

}


