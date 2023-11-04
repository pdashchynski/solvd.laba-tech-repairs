package main.java.services;

import main.java.items.Computer;
import main.java.items.ItemGeneration;

import java.util.Random;

public class ServiceGeneration {

    private final String[] serviceTypeArray = new String[] {"Cleaning", "Diagnostics", "Repair"};
    private int baseTime = 24;
    private int baseCost = 100;
    Random random = new Random();
    ItemGeneration ig = new ItemGeneration();

    public String serviceTypeGenerate () {
        return serviceTypeArray[random.nextInt(serviceTypeArray.length)];
    }

    public Cleaning cleaningGenerate (String serviceType) {
        return new Cleaning(
                serviceType,
                baseCost/2,
                random.nextBoolean()
                );
    }

    public Diagnostics diagnosticsGenerate (String serviceType) {
        return new Diagnostics(
                serviceType,
                baseCost/3,
                random.nextBoolean()
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
}
