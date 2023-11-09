package main.java.items;

import main.java.interaction.Interaction;
import main.java.persons.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static main.java.Executor.RANDOM;

public final class ItemGenerator {

    private static final Logger LOGGER = LogManager.getLogger(ItemGenerator.class);
    private static String[] brandNameArray = new String[] {"AMD", "Nvidia", "Intel", "Lxino"};
    private static String[] modelNameArray = new String[] {"100", "300", "400", "600", "700", "900"};
    private static String[] colourArray = new String[] {"White", "Red", "Black", "Green", "Purple"};


    public String itemBrandNameGenerate () {
        return brandNameArray[RANDOM.nextInt(brandNameArray.length)];
    }

    public String itemModelNameGenerate () {
        return modelNameArray[RANDOM.nextInt(modelNameArray.length)];
    }

    public String itemColourGenerate () {
        return colourArray[RANDOM.nextInt(colourArray.length)];
    }

    public String itemManufacturerDateGenerate () {
        return String.valueOf((RANDOM.nextInt(20) + 2000));
    }

    public Computer computerGenerate () {
        return new Computer(
                itemBrandNameGenerate(),
                itemModelNameGenerate(),
                itemColourGenerate(),
                itemManufacturerDateGenerate()
        );
    }

    public SparePart sparePartGenerate () {
        return new SparePart(
                itemBrandNameGenerate(),
                itemModelNameGenerate(),
                itemColourGenerate(),
                itemManufacturerDateGenerate(),
                RANDOM.nextBoolean()
        );
    }

    public void clientAddComputersGenerate (Client client) {
        int amount = RANDOM.nextInt(3) + 1;
        for (int i = 0; i < amount; i++) {
            client.addComputerToComputerList(computerGenerate());
        }
    }

    public void computerAddSparePartsGenerate (Computer computer) {
        int amount = RANDOM.nextInt(3) + 1;
        LOGGER.debug(amount + " parts");
        for (int i = 0; i < amount; i++) {
            computer.addSparePartToSparePartList(sparePartGenerate());
        }
    }

    public String[] getBrandNameArray() {
        return brandNameArray;
    }

    public void setBrandNameArray(String[] brandNameArray) {
        this.brandNameArray = brandNameArray;
    }

    public String[] getModelNameArray() {
        return modelNameArray;
    }

    public void setModelNameArray(String[] modelNameArray) {
        this.modelNameArray = modelNameArray;
    }

    public String[] getColourArray() {
        return colourArray;
    }

    public void setColourArray(String[] colourArray) {
        this.colourArray = colourArray;
    }
}
