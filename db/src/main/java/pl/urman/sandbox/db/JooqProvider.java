package pl.urman.sandbox.db;


import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Singleton
public class JooqProvider implements Provider<DSLContext> {

    private final DataSource dataSource;

    @Inject
    public JooqProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public DSLContext get() {
        return DSL.using(dataSource, SQLDialect.POSTGRES);
    }
}
