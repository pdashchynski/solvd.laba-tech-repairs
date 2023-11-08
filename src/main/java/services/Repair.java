package main.java.services;

import main.java.items.Item;

public class Repair extends Service{

    private Item item;

    public Repair() {}

    public Repair(String name, int cost, Item item) {
        super(name, cost);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override public void perform() {
        System.out.println("Repairs in progress");
    }
}
