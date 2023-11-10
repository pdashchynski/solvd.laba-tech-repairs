package main.java.exceptions;

public class InvalidStringInputException extends IllegalArgumentException{

    public InvalidStringInputException() {}

    public InvalidStringInputException(String message) {
        super(message);
    }

    public InvalidStringInputException(Throwable cause) {
        super(cause);
    }

    public InvalidStringInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
