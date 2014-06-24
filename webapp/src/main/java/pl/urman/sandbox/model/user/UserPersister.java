package pl.urman.sandbox.model.user;

import pl.urman.sandbox.db.model.Role;
import javax.inject.Inject;
import org.joda.time.DateTime;

import pl.urman.sandbox.db.Tables;

import org.jooq.DSLContext;

import static pl.urman.sandbox.db.Tables.USERS;
import pl.urman.sandbox.db.tables.records.UsersRecord;
import pl.urman.sandbox.db.tables.records.UsersRolesRecord;

public class UserPersister {

    @Inject
    private DSLContext jooq;

    public Long addUser(User user) {
        UsersRecord userRecord = jooq.newRecord(USERS);
        userRecord.setUsername(user.getUsername());
        userRecord.setEmail(user.getEmail());
        userRecord.setCreateDate(new DateTime());
        userRecord.store();

        UsersRolesRecord rolesRecord = jooq.newRecord(Tables.USERS_ROLES);
        rolesRecord.setRoles(Role.USER);
        rolesRecord.setUsers(userRecord.getId());
        rolesRecord.store();

        return userRecord.getId();
    }


}
