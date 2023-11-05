package main.java.persons;

import main.java.items.Computer;

import java.util.ArrayList;

public class Client extends Person {

    private boolean isOurClient;
    private ArrayList<Computer> computerList = new ArrayList<Computer>();

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

    public ArrayList<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(ArrayList<Computer> computerList) {
        this.computerList = computerList;
    }

    public void addComputerToComputerList(Computer computer) {
        this.computerList.add(computer);
    }

    @Override
    public String toString() {
        return  super.toString() +
                " who came to " + COMPANY_NAME;
    }
}
