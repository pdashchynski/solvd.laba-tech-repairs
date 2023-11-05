package main.java.interaction;

import main.java.items.Computer;
import main.java.items.ItemGeneration;
import main.java.orders.Order;
import main.java.orders.OrderGeneration;
import main.java.persons.*;
import main.java.services.Diagnostics;
import main.java.services.Repair;
import main.java.services.Service;
import main.java.services.ServiceGeneration;

import java.util.*;

public class Interaction {

    Scanner in = new Scanner(System.in);
    Random random = new Random();
    PersonGeneration pg = new PersonGeneration();
    ItemGeneration ig = new ItemGeneration();
    OrderGeneration og = new OrderGeneration();
    ServiceGeneration sg = new ServiceGeneration();

    public void menu() {

        boolean isExit = false;

        while (!isExit) {
            System.out.println("Do you wish to create a new person? (Y/N)");
            String createAnswer = in.next();

            switch (createAnswer) {
                case "Y":
                    System.out.println("What type of a person do you wish to create? (Client/Employee/Master/Partner)");
                    String personType = in.next();
                    pg.personGenerate(personType);
                    break;
                case "N":
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter a correct response");
                    break;
            }
        }

        for (Client client : pg.getClientList()) {
            ig.clientAddComputersGenerate(client);

            for (Computer computer : client.getComputerList()) {
                og.addOrderToOrderList(og.orderGenerate(client, computer, pg.getMasterList().get(random.nextInt(pg.getMasterList().size())) ));
            }
        }

        for (Order order : og.getOrderList()) {
            Client client = order.getClient();
            Computer computer = order.getComputer();
            Master master = order.getMaster();
            Service service = order.getService();
            int totalTime = og.calculateTotalTime(order);
            int totalCost = og.calculateTotalCost(order);
            System.out.println(master.toString() + " " + service.getName() + " "
                    + computer.toString() + " in " + totalTime + " hours");
            System.out.println(client.toString() + " should now pay " + totalCost + " moneys");
        }
    }
}
