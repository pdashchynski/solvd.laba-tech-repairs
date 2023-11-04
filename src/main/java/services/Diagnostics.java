package main.java.services;

public class Diagnostics extends Service {

    private boolean isOK;

    public Diagnostics () {}

    public Diagnostics (String name, int cost, boolean isOK) {
        super(name, cost);
        this.isOK = isOK;
    }

    public boolean isOK() {
        return isOK;
    }

    public void setOK(boolean OK) {
        isOK = OK;
    }

    @Override
    public void action() {
        System.out.println("*beep boop*");
    }
}
