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

    ArrayList<Client> clientList = new ArrayList<Client>();
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    ArrayList<Master> masterList = new ArrayList<Master>();
    ArrayList<Partner> partnerList = new ArrayList<Partner>();

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
                            System.out.println("Please enter a correct response");
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
            ig.clientAddComputersGenerate(client);

            for (Computer computer : client.getComputerList()) {
                og.addOrderToOrderList(og.orderGenerate(client, computer, masterList.get(random.nextInt(masterList.size())) ));
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
