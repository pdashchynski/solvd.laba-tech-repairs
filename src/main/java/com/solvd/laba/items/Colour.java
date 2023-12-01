package com.solvd.laba.items;

import java.util.Random;

public enum Colour {
    WHITE, RED, BLACK, GREEN, PURPLE;

    private static final Random rand = new Random();

    public static String getRandomColour() {
        Colour[] colours = values();
        return colours[rand.nextInt(colours.length)].name();
    }
}
