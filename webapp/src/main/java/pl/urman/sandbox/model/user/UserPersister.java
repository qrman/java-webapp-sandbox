package pl.urman.sandbox.model.user;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.jooq.DSLContext;

import static pl.urman.sandbox.db.Tables.USER;
import pl.urman.sandbox.db.tables.records.UserRecord;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class UserPersister {

    @Inject
    private DSLContext jooq;

    public Response addUser(User user) {
        UserRecord userRecord = jooq.newRecord(USER);
        userRecord.setFirstName(user.getFirstName());
        userRecord.setSecondName(user.getSecondName());
        userRecord.store();
        return Response.ok().build();
    }

    public void deleteAll() {
        jooq.delete(USER).execute();
    }
}
