package main.java.exceptions;

public class ComputerIsNotOKException extends Exception{

    public ComputerIsNotOKException () {}

    public ComputerIsNotOKException (String message) {
        super(message);
    }

    public ComputerIsNotOKException (Throwable cause) {
        super(cause);
    }

    public ComputerIsNotOKException (String message, Throwable cause) {
        super(message, cause);
    }
}
