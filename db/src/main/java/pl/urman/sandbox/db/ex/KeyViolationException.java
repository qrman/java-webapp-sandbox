package pl.urman.sandbox.db.ex;

public class KeyViolationException extends RuntimeException {

    public KeyViolationException(String message, Exception ex) {
        super(message, ex);
    }

    public KeyViolationException(Exception ex) {
        super(ex);
    }
}
