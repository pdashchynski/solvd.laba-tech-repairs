package com.solvd.laba;

import com.solvd.laba.interaction.Interaction;
import com.solvd.laba.pooling.Application;
import com.solvd.laba.pooling.RunnableAndThreadTest;
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

/*        try (IN) {
            interaction.menuInput();
            interaction.menuOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //ReflectionPrinter.printClass("com.solvd.laba.persons.Client");
        //ReflectionCreator.createClass("com.solvd.laba.persons.Client");

        /*RunnableAndThreadTest t = new RunnableAndThreadTest();
        t.test();
        t.testNoName();*/

        Application app = new Application();
        app.launch();
        //app.launchCF();
    }
}
