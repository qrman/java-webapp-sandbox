package pl.urman.sandbox.db.guice;

import javax.sql.DataSource;

import pl.urman.sandbox.db.JooqTestDbProvider;
import pl.urman.sandbox.db.TestDataSourceProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.jooq.DSLContext;

public class TestDbModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(TestDataSourceProvider.class);
        bind(DSLContext.class).toProvider(JooqTestDbProvider.class).in(Singleton.class);
    }

}
