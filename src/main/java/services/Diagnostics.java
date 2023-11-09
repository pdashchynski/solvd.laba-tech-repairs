package main.java.services;

import main.java.interaction.Interaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static main.java.Executor.RANDOM;

public class Diagnostics extends Service {

    private static final Logger LOGGER = LogManager.getLogger(Diagnostics.class);
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
            LOGGER.info(" Everything is OK ");
        } else {
            LOGGER.info(" Additional service is required ");
        }
    }
}
