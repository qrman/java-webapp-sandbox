package pl.urman.sandbox.auth;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String username;
    private String password;

}
