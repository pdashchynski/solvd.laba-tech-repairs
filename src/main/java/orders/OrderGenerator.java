package main.java.orders;

import main.java.interaction.Interaction;
import main.java.items.Computer;
import main.java.items.Item;
import main.java.items.ItemGenerator;
import main.java.items.SparePart;
import main.java.persons.Client;
import main.java.persons.Master;
import main.java.persons.PersonGenerator;
import main.java.services.Service;
import main.java.services.ServiceGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static main.java.Executor.RANDOM;

public final class OrderGenerator {

    private static final Logger LOGGER = LogManager.getLogger(OrderGenerator.class);
    private static ArrayList<Order> orderList = new ArrayList<Order>();
    private PersonGenerator pg = new PersonGenerator();
    private ItemGenerator ig = new ItemGenerator();
    private ServiceGenerator sg = new ServiceGenerator();

    public void ordersGenerate () {
        for (Client client : pg.getClientList()) {
            ig.clientAddComputersGenerate(client);

            for (Computer computer : client.getComputerList()) {
                Master master = pg.getMasterList().get(RANDOM.nextInt(pg.getMasterList().size()));
                Service service = sg.serviceGenerate(computer);
                int orderID = Objects.hash(client, computer, master, service);
                Date serviceDate = new Date();
                computer.setServiceDate(serviceDate);
                orderList.add(new Order(client, computer, master, service, orderID) );
            }
        }
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        OrderGenerator.orderList = orderList;
    }

    public void addOrderToOrderList (Order order) {
        orderList.add(order);
    }
}
