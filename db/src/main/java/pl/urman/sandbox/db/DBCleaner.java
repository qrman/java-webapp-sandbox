package pl.urman.sandbox.db;

import javax.inject.Inject;

import org.jooq.DSLContext;

public class DBCleaner {

    @Inject
    private DSLContext jooq;

    public void apply() {
        jooq.delete(Tables.USERS).execute();
        jooq.execute("ALTER SEQUENCE " + Sequences.USERS_ID_SEQ.getName() + " RESTART WITH 1001");
    }
}
