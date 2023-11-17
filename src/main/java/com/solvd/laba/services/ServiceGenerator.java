package com.solvd.laba.services;

import com.solvd.laba.items.Computer;
import com.solvd.laba.items.ItemGenerator;

import java.util.Random;

public final class ServiceGenerator {

    private static final Random RANDOM = new Random();
    private static final String[] SERVICE_TYPE_ARRAY = new String[] {"Cleaning", "Diagnostics", "Repair"};
    private static final int BASE_TIME = 24;
    private static final int BASE_COST = 100;
    private ItemGenerator ig = new ItemGenerator();

    public String serviceTypeGenerate () {
        return SERVICE_TYPE_ARRAY[RANDOM.nextInt(SERVICE_TYPE_ARRAY.length)];
    }

    public Cleaning cleaningGenerate (String serviceType) {
        return new Cleaning(
                serviceType,
                BASE_COST /2,
                RANDOM.nextBoolean()
                );
    }

    public Diagnostics diagnosticsGenerate (String serviceType) {
        return new Diagnostics(
                serviceType,
                BASE_COST /3,
                RANDOM.nextBoolean()
                );
    }

    public Repair repairGenerate (String serviceType, Computer computer) {
        ig.computerAddSparePartsGenerate(computer);
        return new Repair(
                serviceType,
                BASE_COST,
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
        return BASE_TIME;
    }

    public int getBaseCost() {
        return BASE_COST;
    }

    public String[] getServiceTypeArray() {
        return SERVICE_TYPE_ARRAY;
    }
}
