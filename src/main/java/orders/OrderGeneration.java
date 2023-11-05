package main.java.orders;

import main.java.items.Computer;
import main.java.items.Item;
import main.java.persons.Client;
import main.java.persons.Master;
import main.java.services.Service;
import main.java.services.ServiceGeneration;

import java.util.ArrayList;
import java.util.Random;

public class OrderGeneration {

    private static ArrayList<Order> orderList = new ArrayList<Order>();
    private final Random RANDOM = new Random();
    private ServiceGeneration sg = new ServiceGeneration();

    public Order orderGenerate (Client client, Computer computer, Master master) {
        Service service = sg.serviceGenerate(computer);
        return new Order(client, computer, master, service);
    }

    public int calculateItemCoefficient (Item item) {
        int brandCoefficient = 2;
        if (item.getBrandName().equals("Lxino")) {
            brandCoefficient = 1;
        }
        return brandCoefficient;
    }

    public int calculateTotalCost (Order order) {
        int baseCost = order.getService().getCost();
        return baseCost +
                ( baseCost * order.getMaster().getQualification() / 10) +
                ( baseCost * calculateItemCoefficient(order.getComputer()) / 10);
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
        return delayTime;
    }

    public int calculateTotalTime (Order order) {
        return sg.getBaseTime() +
                ( sg.getBaseTime() / order.getMaster().getQualification() ) +
                calculateDelayTime(order);
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        OrderGeneration.orderList = orderList;
    }

    public void addOrderToOrderList (Order order) {
        orderList.add(order);
    }
}
