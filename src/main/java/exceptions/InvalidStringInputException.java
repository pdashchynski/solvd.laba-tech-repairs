package exceptions;

import java.io.IOException;

public class InvalidStringInputException extends Exception {

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
