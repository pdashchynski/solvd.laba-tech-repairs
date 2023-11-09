package main.java.orders;

import main.java.items.Computer;
import main.java.items.Item;
import main.java.items.ItemGenerator;
import main.java.items.SparePart;
import main.java.persons.Client;
import main.java.persons.Master;
import main.java.persons.PersonGenerator;
import main.java.services.Service;
import main.java.services.ServiceGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static main.java.Executor.RANDOM;

public final class OrderGenerator {

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

    public int calculateItemCoefficient (Item item) {
        int brandCoefficient = 3;
        if (item.getBrandName().equals("Lxino")) {
            brandCoefficient = 2;
        }
        if (item instanceof Computer computer) {
            for (SparePart sparePart : computer.getSparePartList()) {
                if (sparePart.getBrandName().equals("Lxino")) {
                    brandCoefficient += 1;
                } else {
                    brandCoefficient += 2;
                }
            }
        }
        return brandCoefficient;
    }

    public int calculateTotalCost (Order order) {
        int baseCost = order.getService().getCost();
        int totalCost = baseCost +
                ( baseCost * order.getMaster().getQualification() / 10) +
                ( baseCost * calculateItemCoefficient(order.getComputer()) / 10);
        order.setTotalCost(totalCost);
        return totalCost;
    }

    public int calculateDelayTime (Order order) {
        int delayTime = 0;
        if (order.getService().getName().equals("Repair")) {
            for (int i = 0; i < order.getComputer().getSparePartList().size(); i++) {
                if (!order.getComputer().getSparePartList().get(i).isAvailable()) {
                    delayTime += RANDOM.nextInt(7);
                    System.out.println(delayTime + "delay");
                }
            }
        }
        order.setDelayTime(delayTime);
        return delayTime;
    }

    public int calculateTotalTime (Order order) {
        int totalTime = sg.getBaseTime() +
                ( sg.getBaseTime() / order.getMaster().getQualification() ) +
                calculateDelayTime(order);
        order.setTotalTime(totalTime);
        return totalTime;
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
