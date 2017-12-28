package model.exceptions;

/**
 * @author Alex Volochai
 */
public class DiscrepancyXSDException extends Exception {

    public DiscrepancyXSDException(String message) {
        super(message);
    }

    public DiscrepancyXSDException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiscrepancyXSDException(Throwable cause) {
        super(cause);
    }

}
