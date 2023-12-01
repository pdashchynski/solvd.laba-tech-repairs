package com.solvd.laba.persons;

import com.solvd.laba.interfaces.Payable;
import com.solvd.laba.interfaces.Taxable;
import com.solvd.laba.interfaces.functional.LambdaTaxable;
import com.solvd.laba.items.Computer;
import com.solvd.laba.orders.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Master extends Employee implements Payable, Taxable {

    private static final Logger LOGGER = LogManager.getLogger(Master.class);
    private int qualification;
    private ArrayList<Computer> computersList = new ArrayList<Computer>();

    public Master () {}

    public Master (String sex, String firstName, String lastName, String passportID, int age, String position, int salary, int qualification) {
        super(sex, firstName, lastName, passportID, age, position, salary);
        this.qualification = qualification;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public ArrayList<Computer> getComputersList() {
        return computersList;
    }

    public void setComputersList(ArrayList<Computer> computersList) {
        this.computersList = computersList;
    }

    public void addComputer(Computer computer) {
        this.computersList.add(computer);
    }

    public void payExtra (Order order) {
        LOGGER.info("Master " + getFirstName() + " " + getLastName() +
                " got paid an additional " + order.getTotalCost()/4 + " moneys for order "
                + order.getOrderID());
    }

    public void tax () {
        LOGGER.info("Master " + getFirstName() + " " + getLastName() +
                " should pay " + getSalary()/4 + " money as taxes this month");
    }

    public LambdaTaxable<Integer> tax = Master -> getSalary() * 2;


    @Override
    public String toString () {
        return super.toString() +
                ", qualification=" + qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Master master = (Master) o;
        return qualification == master.qualification && Objects.equals(computersList, master.computersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), qualification, computersList);
    }
}
