package com.solvd.laba.items;

import java.util.Random;

public enum BrandName {
    AMD, NVIDIA, INTEL, LXINO;

    private static final Random rand = new Random();

    public static String getRandomBrandName() {
        BrandName[] brandNames = values();
        return brandNames[rand.nextInt(brandNames.length)].name();
    }
}
