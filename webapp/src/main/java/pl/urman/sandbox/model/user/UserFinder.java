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
        return jooq.fetch(USER).map((UserRecord record) -> {
            return User.builder()
                .id(record.getId())
                .firstName(record.getFirstName())
                .secondName(record.getSecondName())
                .build();
        });
    }
}
