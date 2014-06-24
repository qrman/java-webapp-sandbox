
package pl.urman.sandbox.db.converter;

import org.jooq.Converter;
import pl.urman.sandbox.db.model.Role;

public class RoleConverter implements Converter<String, Role>{

    @Override
    public Role from(String databaseObject) {
        return Role.valueOf(databaseObject);
    }

    @Override
    public String to(Role userObject) {
        return userObject.name();
    }

    @Override
    public Class<String> fromType() {
        return String.class;
    }

    @Override
    public Class<Role> toType() {
        return Role.class;
    }

}
