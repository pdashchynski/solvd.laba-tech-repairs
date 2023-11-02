package main.java.items;

public class Fan extends Item{

    private String energyClass;
    private int power;

    public Fan() {}

    public Fan(String brandName, String modelName, String colour, String manufactureDate, String energyClass, int power) {
        super(brandName, modelName, colour, manufactureDate);
        this.energyClass = energyClass;
        this.power = power;
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
}
