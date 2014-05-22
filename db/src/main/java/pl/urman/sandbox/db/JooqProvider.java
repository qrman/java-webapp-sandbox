package pl.urman.sandbox.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.google.inject.Provider;
import com.google.inject.Singleton;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Singleton
public class JooqProvider implements Provider<DSLContext> {

    public DSLContext get() {

        Connection conn = null;

        String userName = "sandbox";
        String password = "sandbox";
        String url = "jdbc:postgresql://localhost:5432/sandbox";

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return DSL.using(conn, SQLDialect.POSTGRES);
    }

}
