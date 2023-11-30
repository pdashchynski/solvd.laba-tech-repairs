package com.solvd.laba;

import com.solvd.laba.custom.CustomLinkedListUsage;
import com.solvd.laba.interaction.Interaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Executor {

    private static final Scanner IN = new Scanner(System.in);

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

    public static void main(String[] args) {

        Interaction interaction = new Interaction();

        try (IN) {
            interaction.menuInput();
            interaction.menuOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
