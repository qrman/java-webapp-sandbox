package pl.urman.sandbox.model.user;

import pl.urman.sandbox.db.model.Role;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import static pl.urman.sandbox.db.Tables.USERS;
import static pl.urman.sandbox.db.Tables.USERS_ROLES;
import pl.urman.sandbox.db.tables.records.UsersRecord;

public class UserFinder {

    @Inject
    private DSLContext jooq;

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
            List<Role> roles = jooq.select(USERS_ROLES.ROLES)
                    .from(USERS_ROLES).where(USERS_ROLES.USERS.eq(ur.getValue(USERS.ID)))
                    .fetch(USERS_ROLES.ROLES);
            return User.builder()
                    .id(ur.getValue(USERS.ID))
                    .username(ur.getValue(USERS.USERNAME))
                    .email(ur.getValue(USERS.EMAIL))
                    .roles(roles)
                    .build();
        }
    }
}
