package pl.urman.sandbox.model.user;

import pl.urman.sandbox.db.model.Role;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private long id;
    private String username;
    private String email;
    private List<Role> roles;
}
