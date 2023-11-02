package main.java.items;

public class WashingMashine extends Item{

    private String energyClass;
    private int power;
    private int capacity;

    public WashingMashine() {}

    public WashingMashine(String brandName, String modelName, String colour, String manufactureDate, String energyClass, int power, int capacity) {
        super(brandName, modelName, colour, manufactureDate);
        this.energyClass = energyClass;
        this.power = power;
        this.capacity = capacity;
    }

    public String getEnergyClass() {
        return energyClass;
    }

    public void setEnergyClass(String energyClass) {
        this.energyClass = energyClass;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
