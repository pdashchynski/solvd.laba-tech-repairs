package main.java.services;

public class Cleaning extends Service{

    private boolean isThorough;

    public Cleaning() {}

    public Cleaning(String name, int price, boolean isThorough) {
        super(name, price);
        this.isThorough = isThorough;
    }

    public boolean isThorough() {
        return isThorough;
    }

    public void setThorough(boolean thorough) {
        isThorough = thorough;
    }

    @Override public void action() {
        System.out.println("*vacuum cleaner noises*");
    };
}
