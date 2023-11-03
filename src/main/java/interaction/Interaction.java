package main.java.interaction;

import main.java.persons.Person;
import main.java.persons.PersonGeneration;

import java.util.Scanner;

public class Interaction {

    public void menu() {

        Scanner in = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {
            System.out.println("Do you wish to create a new person? (Y/N)");
            String createAnswer = in.next();

            switch (createAnswer) {
                case "Y":
                    PersonGeneration pg = new PersonGeneration();
                    Person person = pg.typeGenerate();
                    System.out.println(person);
                    // should return a person
                    break;
                case "N":
                    //isExit = false;
                    //break;
                    return;
                default:
                    System.out.println("Please enter a correct response");
                    break;
            }
        }
    }

}
