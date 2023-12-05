package com.solvd.laba;

import com.solvd.laba.custom.ReflectionCreator;
import com.solvd.laba.custom.ReflectionPrinter;
import com.solvd.laba.interaction.Interaction;
import com.solvd.laba.persons.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Executor {

    private static final Scanner IN = new Scanner(System.in);

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

    public static void main(String[] args) {

        Interaction interaction = new Interaction();

/*        try (IN) {
            interaction.menuInput();
            interaction.menuOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        ReflectionPrinter.printClass("com.solvd.laba.persons.Client");
        ReflectionCreator.createClass("com.solvd.laba.persons.Client");
    }
}
