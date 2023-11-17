package orders;

import exceptions.IllegalCoefficientException;
import items.Computer;
import items.Item;
import items.SparePart;
import services.ServiceGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public final class OrderCalculation {

    private static final Random RANDOM = new Random();
    private static final Logger LOGGER = LogManager.getLogger(OrderCalculation.class);

    public static int calculateItemCoefficient (Item item) throws IllegalCoefficientException {
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
        if (brandCoefficient <= 0) {
            throw new IllegalCoefficientException();
        }
        return brandCoefficient;
    }

    public static int calculateTotalCost (Order order) {
        int baseCost = order.getService().getCost();
        int totalCost = baseCost +
                ( baseCost * order.getMaster().getQualification() / 10) +
                ( baseCost * calculateItemCoefficient(order.getComputer()) / 10);
        order.setTotalCost(totalCost);
        return totalCost;
    }

    public static int calculateDelayTime (Order order) {
        int delayTime = 0;
        if (order.getService().getName().equals("Repair")) {
            for (int i = 0; i < order.getComputer().getSparePartList().size(); i++) {
                if (!order.getComputer().getSparePartList().get(i).isAvailable()) {
                    delayTime += RANDOM.nextInt(7);
                    LOGGER.debug(delayTime + "delay");
                }
            }
        }
        order.setDelayTime(delayTime);
        return delayTime;
    }

    public static int calculateTotalTime (Order order) {
        ServiceGenerator sg = new ServiceGenerator();
        int totalTime = sg.getBaseTime() +
                ( sg.getBaseTime() / order.getMaster().getQualification() ) +
                calculateDelayTime(order);
        order.setTotalTime(totalTime);
        return totalTime;
    }

}
