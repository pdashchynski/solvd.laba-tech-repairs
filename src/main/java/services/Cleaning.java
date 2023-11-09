package main.java.services;

import main.java.interaction.Interaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cleaning extends Service{

    private static final Logger LOGGER = LogManager.getLogger(Cleaning.class);
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
        LOGGER.info("*vacuum cleaner noises*");
    };
}
