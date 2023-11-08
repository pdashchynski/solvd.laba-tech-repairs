package main.java;

import main.java.interaction.Interaction;
import main.java.items.ItemGenerator;
import main.java.orders.OrderGenerator;
import main.java.persons.PersonGenerator;
import main.java.services.ServiceGenerator;

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
