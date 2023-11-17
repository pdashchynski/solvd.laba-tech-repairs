package services;

import interaction.Interaction;
import items.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Repair extends Service{

    private static final Logger LOGGER = LogManager.getLogger(Repair.class);
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
        LOGGER.info("Repairs in progress");
    }
}
