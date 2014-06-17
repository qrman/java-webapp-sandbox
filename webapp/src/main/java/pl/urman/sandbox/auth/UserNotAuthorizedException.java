package pl.urman.sandbox.auth;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class UserNotAuthorizedException extends Exception {

    public UserNotAuthorizedException(String message) {
        super(message);
    }
}
