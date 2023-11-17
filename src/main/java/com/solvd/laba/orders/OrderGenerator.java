package com.solvd.laba.orders;

import com.solvd.laba.items.Computer;
import com.solvd.laba.items.ItemGenerator;
import com.solvd.laba.persons.Client;
import com.solvd.laba.persons.Master;
import com.solvd.laba.persons.PersonGenerator;
import com.solvd.laba.services.Service;
import com.solvd.laba.services.ServiceGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public final class OrderGenerator {

    private static final Random RANDOM = new Random();
    private static final Logger LOGGER = LogManager.getLogger(OrderGenerator.class);
    private static LinkedList<Order> orderList = new LinkedList<>();
    private static Map<Integer, Master> orderIDMasterHashMap = new HashMap<>();
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
                orderIDMasterHashMap.put(orderID, master);
                orderList.addLast(new Order(client, computer, master, service, orderID) );
            }
        }
    }

    public LinkedList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(LinkedList<Order> orderList) {
        OrderGenerator.orderList = orderList;
    }

    public void addOrderToOrderList (Order order) {
        orderList.add(order);
    }
}
