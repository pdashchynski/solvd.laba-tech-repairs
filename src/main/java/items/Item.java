package main.java.items;

public abstract class Item {

    private String brandName;
    private String modelName;
    private String colour;
    private String manufactureDate;

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
}
