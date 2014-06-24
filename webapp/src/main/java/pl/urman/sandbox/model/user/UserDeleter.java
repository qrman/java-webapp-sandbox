package pl.urman.sandbox.model.user;

import javax.inject.Inject;

import static pl.urman.sandbox.db.Tables.USERS;

import org.jooq.DSLContext;

public class UserDeleter {

    @Inject
    private DSLContext jooq;

    public void deleteAll() {
        jooq.delete(USERS).execute();
    }
}
