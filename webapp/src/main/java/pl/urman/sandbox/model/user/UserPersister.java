package pl.urman.sandbox.model.user;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.jooq.DSLContext;

import static pl.urman.sandbox.db.Tables.USERS;
import pl.urman.sandbox.db.tables.records.UsersRecord;

public class UserPersister {

    @Inject
    private DSLContext jooq;

    public Response addUser(User user) {
        UsersRecord userRecord = jooq.newRecord(USERS);
        userRecord.setUsername(user.getUsername());
        userRecord.setEmail(user.getEmail());
        userRecord.store();
        return Response.ok().build();
    }

    public void deleteAll() {
        jooq.delete(USERS).execute();
    }
}
