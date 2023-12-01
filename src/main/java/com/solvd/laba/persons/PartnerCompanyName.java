package com.solvd.laba.persons;

import java.util.Random;

public enum PartnerCompanyName {
    AMD, NVIDIA, INTEL , FOODIES;

    private static final Random rand = new Random();

    public static String getRandomPartnerCompanyName() {
        PartnerCompanyName[] partnerCompanyNames = values();
        return partnerCompanyNames[rand.nextInt(partnerCompanyNames.length)].name();
    }
}
