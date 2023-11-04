package main.java.persons;

import main.java.items.Computer;
import main.java.items.Item;

import java.util.ArrayList;

public class Client extends Person {

    private boolean isOurClient;
    private ArrayList<Computer> computersList = new ArrayList<Computer>();

    public Client() {}

    public Client(String sex, String firstName, String lastName, String passportID, int age, boolean isOurClient) {
        super(sex, firstName, lastName, passportID, age);
        this.isOurClient = isOurClient;
    }

    public boolean isOurClient() {
        return isOurClient;
    }

    public void setOurClient(boolean ourClient) {
        isOurClient = ourClient;
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

    @Override
    public String toString() {
        return  super.toString();
    }
}
