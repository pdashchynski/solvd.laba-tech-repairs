package com.solvd.laba.items;

import com.solvd.laba.exceptions.IllegalBrandNameException;
import com.solvd.laba.persons.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public final class ItemGenerator {

    private static final Random RANDOM = new Random();
    private static final Logger LOGGER = LogManager.getLogger(ItemGenerator.class);
    private static final String[] BRAND_NAME_ARRAY = new String[] {"AMD", "Nvidia", "Intel", "Lxino"};
    private static final String[] MODEL_NAME_ARRAY = new String[] {"100", "300", "400", "600", "700", "900"};
    private static final String[] COLOUR_ARRAY = new String[] {"White", "Red", "Black", "Green", "Purple"};


    public String itemBrandNameGenerate () throws IllegalBrandNameException {
        String brandName = BRAND_NAME_ARRAY[RANDOM.nextInt(BRAND_NAME_ARRAY.length)];
        if (!Arrays.asList(BRAND_NAME_ARRAY).contains(brandName)) {
            throw new IllegalBrandNameException("A brand that does not exist!", brandName);
        }
        return brandName;
    }

    public String itemModelNameGenerate () {
        return MODEL_NAME_ARRAY[RANDOM.nextInt(MODEL_NAME_ARRAY.length)];
    }

    public String itemColourGenerate () {
        return COLOUR_ARRAY[RANDOM.nextInt(COLOUR_ARRAY.length)];
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
        return BRAND_NAME_ARRAY;
    }

    public String[] getModelNameArray() {
        return MODEL_NAME_ARRAY;
    }

    public String[] getColourArray() {
        return COLOUR_ARRAY;
    }
}
