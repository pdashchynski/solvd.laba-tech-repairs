package main.java.services;

import static main.java.Executor.RANDOM;

public class Diagnostics extends Service {

    private boolean isOK;

    public Diagnostics () {}

    public Diagnostics (String name, int cost) {
        super(name, cost);
    }

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
    public void perform() {
        this.isOK = RANDOM.nextBoolean();

        if (this.isOK) {
            System.out.println(" Everything is OK ");
        } else {
            System.out.println(" Additional service is required ");
        }
    }
}
