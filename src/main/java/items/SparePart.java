package main.java.items;

import java.util.Objects;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SparePart sparePart = (SparePart) o;
        return isAvailable == sparePart.isAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isAvailable);
    }
}
