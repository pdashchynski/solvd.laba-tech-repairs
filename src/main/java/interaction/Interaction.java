package main.java.interaction;

import main.java.items.Item;
import main.java.items.ItemGeneration;
import main.java.persons.*;
import main.java.services.Service;

import java.util.*;

public class Interaction {

    Scanner in = new Scanner(System.in);
    Random random = new Random();
    PersonGeneration pg = new PersonGeneration();
    ItemGeneration ig = new ItemGeneration();

    ArrayList<Client> clientList = new ArrayList<Client>();
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    ArrayList<Master> masterList = new ArrayList<Master>();
    ArrayList<Partner> partnerList = new ArrayList<Partner>();
    Map<Item, Master> orderMap = new HashMap<Item, Master>();

    public void menu() {

        boolean isExit = false;

        while (!isExit) {
            System.out.println("Do you wish to create a new person? (Y/N)");
            String createAnswer = in.next();

            switch (createAnswer) {
                case "Y":
                    System.out.println("What type of a person do you wish to create? (Client/Employee/Master/Partner)");
                    String personType = in.next();
                    Person person = pg.personGenerate(personType);
                    System.out.println(person);

                    switch (personType) {
                        case "Client":
                            clientList.add((Client) person);
                            break;
                        case "Employee":
                            employeeList.add((Employee) person);
                            break;
                        case "Master":
                            masterList.add((Master) person);
                            break;
                        case "Partner":
                            partnerList.add((Partner) person);
                            break;
                        default:
                            break;
                    }
                    break;
                case "N":
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter a correct response");
                    break;
            }
        }

        for (Client client : clientList) {
            ig.clientAddItems(client);
        }

        for (Map.Entry<Item, Master> entry: orderMap.entrySet()) {
            Item item = entry.getKey();
            Master master = entry.getValue();
            int totalTime = Service.baseTime + ((Service.baseTime) /master.getQualification());
            System.out.println("Master " + master.getFirstName() + " "
                    + master.getLastName() + " fixed an item "
                    + item.toString() + " in " + totalTime + " hours");
        }

        System.out.println(clientList.toString());
        for (Client client : clientList) {
            System.out.println(client.getComputersList().toString());
        }
    }
}
