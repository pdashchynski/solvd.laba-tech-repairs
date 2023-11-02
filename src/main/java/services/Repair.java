package main.java.services;

public class Repair extends Service{

    private String component;
    private String operation;

    public Repair() {}

    public Repair(String name, int price, String component, String operation) {
        super(name, price);
        this.component = component;
        this.operation = operation;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override public void action() {
        System.out.println("Repairs in progress");
    }
}
