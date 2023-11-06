package main.java.interaction;

import main.java.items.Computer;
import main.java.items.ItemGenerator;
import main.java.orders.Order;
import main.java.orders.OrderGenerator;
import main.java.persons.*;
import main.java.services.Diagnostics;
import main.java.services.Service;
import main.java.services.ServiceGenerator;

import java.util.*;

import static main.java.Executor.IN;

public final class Interaction {

    private PersonGenerator pg = new PersonGenerator();
    private ItemGenerator ig = new ItemGenerator();
    private OrderGenerator og = new OrderGenerator();
    private ServiceGenerator sg = new ServiceGenerator();

    public final void menuInput() {

        boolean isExit = false;

        while (!isExit) {
            System.out.println("Do you wish to create a new person? (Y/N)");
            String createAnswer = IN.next();

            switch (createAnswer) {
                case "Y":
                    System.out.println("What type of a person do you wish to create? (Client/Employee/Master/Partner)");
                    String personType = IN.next();
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
        og.ordersGenerate();
    }

    public final void menuOutput () {

        for (Order order : og.getOrderList()) {
            Client client = order.getClient();
            Computer computer = order.getComputer();
            Master master = order.getMaster();
            Service service = order.getService();
            int totalTime = og.calculateTotalTime(order);
            int totalCost = og.calculateTotalCost(order);
            String diagnosticsResult = "";

            if (service instanceof Diagnostics diagnostics) {
                if (diagnostics.isOK()) {
                    diagnosticsResult = " Everything is OK ";
                } else {
                    diagnosticsResult = " Additional service is required ";
                }
            }
            System.out.println(master.toString() + " " + service.getName() + diagnosticsResult + " "
                    + computer.toString() + " in " + totalTime + " hours");
            System.out.println(client.toString() + " should now pay " + totalCost + " moneys");
        }
    }
}
