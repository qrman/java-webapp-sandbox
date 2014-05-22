package pl.urman.sandbox.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Builder;



@Data
@AllArgsConstructor
@Builder
public class User {

    private long id;
    private String firstName;
    private String secondName;
}
