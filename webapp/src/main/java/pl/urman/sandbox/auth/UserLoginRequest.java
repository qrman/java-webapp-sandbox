package pl.urman.sandbox.auth;

import lombok.Data;

@Data
public class UserLoginRequest {

    String username;
    String password;

}
