package main.java.services;

public abstract class Service {

    private String name;
    private int cost;
    public static int baseTime = 24;

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

    public abstract void action();
}
