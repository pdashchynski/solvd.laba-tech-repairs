package main.java.services;

public class Cleaning extends Service{

    private boolean isThorough;

    public Cleaning() {}

    public Cleaning(String name, int cost, boolean isThorough) {
        super(name, cost);
        this.isThorough = isThorough;
    }

    public boolean isThorough() {
        return isThorough;
    }

    public void setThorough(boolean thorough) {
        isThorough = thorough;
    }

    @Override public void perform() {
        System.out.println("*vacuum cleaner noises*");
    };
}
