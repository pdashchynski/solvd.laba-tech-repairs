package main.java.exceptions;

public class InvalidBrandNameException extends IllegalArgumentException{

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public InvalidBrandNameException () {}

    public InvalidBrandNameException (String message, String brandName) {
        super(message);
        this.brandName = brandName;
    }

    public InvalidBrandNameException (Throwable cause) {
        super(cause);
    }

    public InvalidBrandNameException (String message, Throwable cause, String brandName) {
        super(message, cause);
        this.brandName = brandName;
    }
}
