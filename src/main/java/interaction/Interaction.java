package interaction;

import exceptions.ComputerIsNotOKException;
import exceptions.InvalidAgeException;
import exceptions.InvalidStringInputException;
import items.Computer;
import items.ItemGenerator;
import orders.Order;
import orders.OrderGenerator;
import persons.*;
import services.Diagnostics;
import services.Service;
import services.ServiceGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

import static orders.OrderCalculation.calculateTotalCost;
import static orders.OrderCalculation.calculateTotalTime;

public final class Interaction {

    private static final Scanner IN = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(Interaction.class);
    private PersonGenerator pg = new PersonGenerator();
    private ItemGenerator ig = new ItemGenerator();
    private OrderGenerator og = new OrderGenerator();
    private ServiceGenerator sg = new ServiceGenerator();

    public final void menuInput() {

        boolean isExit = false;

        while (!isExit) {

            LOGGER.info("Do you wish to create a new person? (Y/N)");
            String createAnswer = "";
            try {
                createAnswer = IN.next();
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }

            switch (createAnswer) {
                case "Y":
                    LOGGER.info("What type of a person do you wish to create? (Client/Employee/Master/Partner)");
                    String personType = "";
                    try {
                        personType = IN.next();
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                    }
                    pg.personGenerate(personType);
                    break;
                case "N":
                    isExit = true;
                    break;
                default:
                    try {
                        throw new InvalidStringInputException();
                    } catch (InvalidStringInputException e) {
                        e.printStackTrace();
                    }
                    LOGGER.info("Please enter a correct response");
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
            int totalTime = calculateTotalTime(order);
            int totalCost = calculateTotalCost(order);

            LOGGER.info(master.toString() + " " + service.getName() + " "
                    + computer.toString() + " in " + totalTime + " hours");
            try {
                computer.boot();
            } catch (ComputerIsNotOKException e) {
                LOGGER.debug(e.getMessage());
            }
            master.payExtra(order);
            master.greet(client);
            LOGGER.info("You should now pay " + totalCost + " moneys");
        }
    }
}
