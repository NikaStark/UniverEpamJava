package entities.exceptions;

/**
 * @author Alex Volochai
 */
public class PersistentException extends Exception {

    public PersistentException(String message) {
        super(message);
    }

    public PersistentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistentException(Throwable cause) {
        super(cause);
    }

}
