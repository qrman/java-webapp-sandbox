package pl.urman.sandbox.db;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.jooq.DSLContext;

public class DbModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DSLContext.class).toProvider(JooqProvider.class).in(Singleton.class);
    }

}
