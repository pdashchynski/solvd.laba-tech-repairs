package exceptions;

public class IllegalBrandNameException extends IllegalArgumentException{

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public IllegalBrandNameException() {}

    public IllegalBrandNameException(String message, String brandName) {
        super(message);
        this.brandName = brandName;
    }

    public IllegalBrandNameException(Throwable cause) {
        super(cause);
    }

    public IllegalBrandNameException(String message, Throwable cause, String brandName) {
        super(message, cause);
        this.brandName = brandName;
    }
}
