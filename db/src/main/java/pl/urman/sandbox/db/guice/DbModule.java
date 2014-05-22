package pl.urman.sandbox.db.guice;

import javax.sql.DataSource;

import pl.urman.sandbox.db.DataSourceProvider;
import pl.urman.sandbox.db.JooqProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.jooq.DSLContext;

public class DbModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(DataSourceProvider.class);
        bind(DSLContext.class).toProvider(JooqProvider.class).in(Singleton.class);
    }

}
