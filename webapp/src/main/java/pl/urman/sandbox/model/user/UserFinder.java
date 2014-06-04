package pl.urman.sandbox.model.user;

import java.util.List;

import javax.inject.Inject;

import pl.urman.sandbox.db.tables.records.UserRecord;

import org.jooq.DSLContext;

import static pl.urman.sandbox.db.Tables.USER;

public class UserFinder {

    @Inject
    DSLContext jooq;

    public List<User> fetchAll() {
        return jooq.selectFrom(USER)
            .orderBy(USER.USERNAME.asc(), USER.EMAIL.asc())
            .fetch()
            .map((UserRecord record) -> {
                return User.builder()
                .id(record.getId())
                .username(record.getUsername())
                .email(record.getEmail())
                .build();
            });
    }

    public User findById(Long userId) {
        UserRecord ur = jooq.fetchOne(USER, USER.ID.eq(userId));
        return new User(ur.getId(), ur.getUsername(), ur.getEmail());
    }

    public User findByUsername(String username) {
        UserRecord ur = jooq.fetchOne(USER, USER.USERNAME.eq(username));
        return new User(ur.getId(), ur.getUsername(), ur.getEmail());
    }
}
