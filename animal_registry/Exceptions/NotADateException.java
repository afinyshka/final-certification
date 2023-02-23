package animal_registry.Exceptions;


public class NotADateException extends NumberFormatException {
    public NotADateException(String message) {
        super(message);
    }
}