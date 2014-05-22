package pl.urman.sandbox.db;

import java.sql.Connection;
import java.sql.SQLException;

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

    public DSLContext get() {
        try {
            Connection conn = dataSource.getConnection();
            return DSL.using(conn, SQLDialect.POSTGRES);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
