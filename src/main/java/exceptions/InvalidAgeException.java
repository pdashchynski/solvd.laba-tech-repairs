package main.java.exceptions;

import java.util.logging.Logger;

public class InvalidAgeException extends Exception{

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public InvalidAgeException () {}

    public InvalidAgeException (String message, int age) {
        super(message);
        this.age = age;
    }

    public InvalidAgeException (Throwable cause) {
        super(cause);
    }

    public InvalidAgeException (String message,Throwable cause, int age) {
        super(message, cause);
        this.age = age;
    }
}
