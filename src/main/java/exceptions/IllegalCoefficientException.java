package main.java.exceptions;

public class IllegalCoefficientException extends IllegalArgumentException {

    public IllegalCoefficientException() {}

    public IllegalCoefficientException(String message) {
        super(message);
    }

    public IllegalCoefficientException(Throwable cause) {
        super(cause);
    }

    public IllegalCoefficientException(String message, Throwable cause) {
        super(message, cause);
    }
}
