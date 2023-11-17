package services;

import interfaces.Performable;

public abstract class Service implements Performable {

    private String name;
    private int cost;

    public Service() {}

    public Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract void perform();
}
