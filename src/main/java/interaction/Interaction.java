package main.java.interaction;

import main.java.items.Item;
import main.java.items.ItemGeneration;
import main.java.persons.*;
import main.java.services.Service;

import java.util.*;

public class Interaction {

    public void menu() {

        Scanner in = new Scanner(System.in);
        Random random = new Random();
        boolean isExit = false;
        PersonGeneration pg = new PersonGeneration();
        ItemGeneration ig = new ItemGeneration();

        ArrayList<Client> clientList = new ArrayList<Client>();
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        ArrayList<Master> masterList = new ArrayList<Master>();
        ArrayList<Partner> partnerList = new ArrayList<Partner>();

        Map<Item, Master> orderMap = new HashMap<Item, Master>();

        while (!isExit) {
            int token = 0;
            Person person = null;
            System.out.println("Do you wish to create a new person? (Y/N)");
            String createAnswer = in.next();

            switch (createAnswer) {
                case "Y":
                    System.out.println("Is that person male or female? (M/F)");
                    String sexAnswer = in.next();

                    if (sexAnswer.equals("M") | sexAnswer.equals("F")) {
                        PersonGeneration.PersonWrap personWrap = pg.typeGenerate(sexAnswer);
                        person = personWrap.getPerson();
                        System.out.println(personWrap.getPerson());
                        token = personWrap.getToken();
                        System.out.println(token);
                    } else {
                        System.out.println("Please enter a correct response");
                    }

                    switch (token) {
                        case 1:
                            clientList.add((Client) person);
                            break;
                        case 2:
                            employeeList.add((Employee) person);
                            break;
                        case 3:
                            masterList.add((Master) person);
                            break;
                        case 4:
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

                System.out.println("How many items does client " + client.getFirstName() + " " + client.getLastName() + " have?");
                int itemsAnswer = in.nextInt();

                for (int i = 0; i < itemsAnswer; i++) {
                    client.addItem(ig.itemGenerate());
                }

                for (Item item : client.getItemsList()) {
                    int i = random.nextInt(masterList.size());
                    orderMap.put(item, (masterList.get(i)));
                }
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
            System.out.println(client.getItemsList().toString());
        }
    }
}
