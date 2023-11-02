package main.java.items;

public class Phone extends Item{

    private String imei;
    private int batteryCapacity;
    private double screenSize;

    public Phone() {}

    public Phone(String brandName, String modelName, String colour, String manufactureDate, String imei, int batteryCapacity, double screenSize) {
        super(brandName, modelName, colour, manufactureDate);
        this.imei = imei;
        this.batteryCapacity = batteryCapacity;
        this.screenSize = screenSize;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
