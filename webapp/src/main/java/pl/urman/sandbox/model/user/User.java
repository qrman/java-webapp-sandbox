package pl.urman.sandbox.model.user;

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
}
