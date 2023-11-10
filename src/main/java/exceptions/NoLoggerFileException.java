package main.java.exceptions;

import java.io.IOException;

public class NoLoggerFileException extends IOException {

    public NoLoggerFileException () {}

    public NoLoggerFileException (String message) {
        super(message);
    }

    public NoLoggerFileException (Throwable cause) {
        super(cause);
    }

    public NoLoggerFileException (String message, Throwable cause) {
        super(message, cause);
    }
}
