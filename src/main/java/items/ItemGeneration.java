package main.java.items;

import main.java.persons.Client;

import java.util.Random;

public class ItemGeneration {

    private final String[] brandNameArray = new String[] {"AMD", "Nvidia", "Intel", "Lxino"};
    private final String[] modelNameArray = new String[] {"100", "300", "400", "600", "700", "900"};
    private final String[] colourArray = new String[] {"White", "Red", "Black", "Green", "Purple"};
    Random random = new Random();

    public String itemBrandNameGenerate () {
        return brandNameArray[random.nextInt(brandNameArray.length)];
    }

    public String itemModelNameGenerate () {
        return modelNameArray[random.nextInt(modelNameArray.length)];
    }

    public String itemColourGenerate () {
        return colourArray[random.nextInt(colourArray.length)];
    }

    public String itemManufacturerDateGenerate () {
        return String.valueOf((random.nextInt(20) + 2000));
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
                random.nextBoolean()
        );
    }

    public void clientAddComputersGenerate (Client client) {
        int amount = random.nextInt(3) + 1;
        for (int i = 0; i < amount; i++) {
            client.addComputerToComputerList(computerGenerate());
        }
    }

    public void computerAddSparePartsGenerate (Computer computer) {
        int amount = random.nextInt(3) + 1;
        System.out.println(amount + " parts");
        for (int i = 0; i < amount; i++) {
            computer.addSparePartToSparePartList(sparePartGenerate());
        }
    }
}
