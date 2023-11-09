package main.java.services;

import main.java.items.Computer;
import main.java.items.ItemGenerator;

import java.util.Random;

import static main.java.Executor.RANDOM;

public final class ServiceGenerator {

    private static String[] serviceTypeArray = new String[] {"Cleaning", "Diagnostics", "Repair"};
    private static int baseTime = 24;
    private static int baseCost = 100;
    private ItemGenerator ig = new ItemGenerator();

    public String serviceTypeGenerate () {
        return serviceTypeArray[RANDOM.nextInt(serviceTypeArray.length)];
    }

    public Cleaning cleaningGenerate (String serviceType) {
        return new Cleaning(
                serviceType,
                baseCost/2,
                RANDOM.nextBoolean()
                );
    }

    public Diagnostics diagnosticsGenerate (String serviceType) {
        return new Diagnostics(
                serviceType,
                baseCost/3,
                RANDOM.nextBoolean()
                );
    }

    public Repair repairGenerate (String serviceType, Computer computer) {
        ig.computerAddSparePartsGenerate(computer);
        return new Repair(
                serviceType,
                baseCost,
                computer
        );
    }

    public Service serviceGenerate (Computer computer) {
        Service service = null;

        String serviceType = serviceTypeGenerate();

        switch (serviceType) {
            case "Cleaning":
                service = cleaningGenerate(serviceType);
                break;

            case "Diagnostics":
                service = diagnosticsGenerate(serviceType);
                break;

            case "Repair":
                service = repairGenerate(serviceType, computer);
                break;

            default:
                break;
        }

        return service;
    }

    public int getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(int baseTime) {
        this.baseTime = baseTime;
    }

    public int getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(int baseCost) {
        this.baseCost = baseCost;
    }

    public String[] getServiceTypeArray() {
        return serviceTypeArray;
    }

    public void setServiceTypeArray(String[] serviceTypeArray) {
        this.serviceTypeArray = serviceTypeArray;
    }

}
