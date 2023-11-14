package main.java.interaction;

import main.java.Executor;
import main.java.exceptions.ComputerIsNotOKException;
import main.java.exceptions.InvalidAgeException;
import main.java.exceptions.InvalidStringInputException;
import main.java.items.Computer;
import main.java.items.ItemGenerator;
import main.java.orders.Order;
import main.java.orders.OrderGenerator;
import main.java.persons.*;
import main.java.services.Diagnostics;
import main.java.services.Service;
import main.java.services.ServiceGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

import static main.java.Executor.IN;
import static main.java.orders.OrderCalculation.calculateTotalCost;
import static main.java.orders.OrderCalculation.calculateTotalTime;

public final class Interaction {

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
