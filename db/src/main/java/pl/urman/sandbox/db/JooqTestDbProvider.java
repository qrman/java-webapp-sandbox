package pl.urman.sandbox.db;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Singleton
public class JooqTestDbProvider implements Provider<DSLContext> {

    @Inject
    private DataSource dataSource;


    @Override
    public DSLContext get() {
        return DSL.using(dataSource, SQLDialect.POSTGRES);
    }

}
