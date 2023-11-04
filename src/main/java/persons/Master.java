package main.java.persons;

import main.java.items.Computer;
import main.java.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Master extends Employee {

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
}
