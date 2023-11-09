package main.java.items;

import main.java.interaction.Interaction;
import main.java.interfaces.Bootable;
import main.java.orders.Order;
import main.java.orders.OrderGenerator;
import main.java.persons.PersonGenerator;
import main.java.services.Diagnostics;
import main.java.services.ServiceGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Computer extends Item implements Bootable {

    private static final Logger LOGGER = LogManager.getLogger(Computer.class);
    private ArrayList<SparePart> sparePartList = new ArrayList<SparePart>();
    private OrderGenerator og = new OrderGenerator();

    public Computer() {}

    public Computer(String brandName, String modelName, String colour, String manufactureDate) {
        super(brandName, modelName, colour, manufactureDate);
    }

    public ArrayList<SparePart> getSparePartList() {
        return sparePartList;
    }

    public void setSparePartList(ArrayList<SparePart> sparePartList) {
        this.sparePartList = sparePartList;
    }

    public void addSparePartToSparePartList(SparePart sparePart) {
        this.sparePartList.add(sparePart);
    }

    public void boot () {
        for (Order order : og.getOrderList()) {
            if(order.getComputer().equals(this)) {
                if (order.getService() instanceof Diagnostics diagnostics) {
                    if (diagnostics.isOK()) {
                        LOGGER.info("Booting up");
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Computer computer = (Computer) o;
        return Objects.equals(sparePartList, computer.sparePartList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sparePartList);
    }
}
