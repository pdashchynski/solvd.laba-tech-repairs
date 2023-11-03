package main.java.persons;

import main.java.items.Item;

import java.util.ArrayList;

public class Client extends Person {

    private boolean isOurClient;
    private ArrayList<Item> itemsList = new ArrayList<Item>();

    public Client() {}

    public Client(char sex, String firstName, String lastName, String passportID, int age, boolean isOurClient) {
        super(sex, firstName, lastName, passportID, age);
        this.isOurClient = isOurClient;
    }

    public boolean isOurClient() {
        return isOurClient;
    }

    public void setOurClient(boolean ourClient) {
        isOurClient = ourClient;
    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public void addItem(Item item) {
        this.itemsList.add(item);
    }

    @Override
    public String toString() {
        return  super.toString();
    }
}
