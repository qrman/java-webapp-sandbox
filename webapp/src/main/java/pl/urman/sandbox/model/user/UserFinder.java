package pl.urman.sandbox.model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.Result;
import static pl.urman.sandbox.db.Tables.USERS;
import static pl.urman.sandbox.db.Tables.USERS_ROLES;
import pl.urman.sandbox.db.tables.records.UsersRecord;
import pl.urman.sandbox.db.tables.records.UsersRolesRecord;

public class UserFinder {

    @Inject
    DSLContext jooq;

    public List<User> fetchAll() {
        return jooq.selectFrom(USERS)
                .orderBy(USERS.USERNAME.asc(), USERS.EMAIL.asc())
                .fetch()
                .map(new UserRecordMapper());
    }

    public User findById(Long userId) {
        return jooq.selectFrom(USERS).where(USERS.ID.eq(userId))
                .fetchOne()
                .map(new UserRecordMapper());
    }

    public Optional<User> findByUsername(String username) {
        UsersRecord ur = jooq.fetchOne(USERS, USERS.USERNAME.eq(username));
        return ur != null
                ? Optional.of(ur.map(new UserRecordMapper()))
                : Optional.<User>empty();
    }

    private class UserRecordMapper implements RecordMapper<Record, User> {

        @Override
        public User map(Record ur) {
            Result<UsersRolesRecord> rolesRecords = jooq.selectFrom(USERS_ROLES).where(USERS_ROLES.USERS.eq(ur.getValue(USERS.ID))).fetch();
            List<Role> roles = new ArrayList<>();
            for (UsersRolesRecord usersRolesRecord : rolesRecords) {
                String r = usersRolesRecord.getRoles();
                roles.add(Role.valueOf(r));
            }
            return User.builder()
                    .id(ur.getValue(USERS.ID))
                    .username(ur.getValue(USERS.USERNAME))
                    .email(ur.getValue(USERS.EMAIL))
                    .roles(roles)
                    .build();
        }
    }
}
