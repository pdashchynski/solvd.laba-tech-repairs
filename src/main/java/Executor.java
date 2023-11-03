package main.java;

import main.java.buildings.Office;
import main.java.interaction.Interaction;
import main.java.persons.Client;
import main.java.persons.Employee;
import main.java.services.Cleaning;
import main.java.services.Service;

public class Executor {

    public static void main(String[] args) {

        Interaction interaction = new Interaction();

        interaction.menu();
    }
}
