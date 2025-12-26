package exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        super("Invalid Input, words should be only letters and number should be between 1 to 26");
    }
}
