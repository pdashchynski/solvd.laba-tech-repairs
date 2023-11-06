package main.java;

import main.java.interaction.Interaction;

import java.util.Random;
import java.util.Scanner;

public class Executor {

    public static final Random RANDOM = new Random();
    public static final Scanner IN = new Scanner(System.in);

    static {
        System.out.println("Static block execution");
    }

    public static void main(String[] args) {

        Interaction interaction = new Interaction();

        interaction.menuInput();
        interaction.menuOutput();
    }
}
