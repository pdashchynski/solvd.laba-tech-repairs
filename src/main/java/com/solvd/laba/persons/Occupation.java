package com.solvd.laba.persons;

import com.solvd.laba.items.BrandName;

import java.util.Random;

public enum Occupation {
    MANAGER, ADMINISTRATOR, CLEANER;
    private static final Random rand = new Random();

    public static String getRandomOccupation() {
        Occupation[] occupations = values();
        return occupations[rand.nextInt(occupations.length)].name();
    }
}
