package main.java.items;

import java.util.Date;
import java.util.Objects;

public abstract class Item {

    private String brandName;
    private String modelName;
    private String colour;
    private String manufactureDate;
    private Date serviceDate;

    public Item() {}

    public Item(String brandName, String modelName, String colour, String manufactureDate) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.colour = colour;
        this.manufactureDate = manufactureDate;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    @Override
    public String toString() {
        return "brandName='" + brandName  + '\'' +
                ",modelName='" + modelName + '\'' +
                ", colour='" + colour + '\'' +
                ", manufactureDate='" + manufactureDate + "' ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(brandName, item.brandName) &&
                Objects.equals(modelName, item.modelName) &&
                Objects.equals(colour, item.colour) &&
                Objects.equals(manufactureDate, item.manufactureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, modelName, colour, manufactureDate);
    }
}
