package animal_registry.Exceptions;

public class NotAStringException extends NumberFormatException {
    public NotAStringException(String message) {
        super(message);
    }
    
}
