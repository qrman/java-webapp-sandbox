package pl.urman.sandbox.model.user;

import java.util.List;

import javax.inject.Inject;

import static pl.urman.sandbox.db.Tables.USERS;
import pl.urman.sandbox.db.tables.records.UsersRecord;

import org.jooq.DSLContext;

public class UserFinder {

    @Inject
    DSLContext jooq;

    public List<User> fetchAll() {
        return jooq.selectFrom(USERS)
            .orderBy(USERS.USERNAME.asc(), USERS.EMAIL.asc())
            .fetch()
            .map((UsersRecord record) -> {
                return User.builder()
                .id(record.getId())
                .username(record.getUsername())
                .email(record.getEmail())
                .build();
            });
    }

    public User findById(Long userId) {
        UsersRecord ur = jooq.fetchOne(USERS, USERS.ID.eq(userId));
        return new User(ur.getId(), ur.getUsername(), ur.getEmail());
    }

    public User findByUsername(String username) {
        UsersRecord ur = jooq.fetchOne(USERS, USERS.USERNAME.eq(username));
        return new User(ur.getId(), ur.getUsername(), ur.getEmail());
    }
}
