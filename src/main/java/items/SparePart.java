package main.java.items;

public class SparePart extends Item {

    private boolean isAvailable;

    public SparePart () {}

    public SparePart (String brandName, String modelName, String colour, String manufactureDate, boolean isAvailable) {
        super(brandName, modelName, colour, manufactureDate);
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
