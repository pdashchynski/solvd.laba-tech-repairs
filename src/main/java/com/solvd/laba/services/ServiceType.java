package com.solvd.laba.services;

import com.solvd.laba.persons.PartnerCompanyName;

import java.util.Random;

public enum ServiceType {
    CLEANING, DIAGNOSTICS, REPAIR;
    private static final Random rand = new Random();

    public static String getRandomServiceType() {
        ServiceType[] serviceTypes = values();
        return serviceTypes[rand.nextInt(serviceTypes.length)].name();
    }
}
