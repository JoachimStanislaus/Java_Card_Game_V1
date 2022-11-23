/**
 * Thrown when attempting to create a pack of cards.
 * 
 * @author 228027 & 231731
 * @version 1.0
 */
public class InvalidNumberOfCardsException extends Exception {

    /**
     * Constructs an instance of the exception with no message
     */
    public InvalidNumberOfCardsException() {
        // do nothing;
    }

    /**
     * Constructs an instance of the exception containing the message argument
     * 
     * @param message message containing details regarding the exception cause
     */
    public InvalidNumberOfCardsException(String message) {
        super(message);
    }
}