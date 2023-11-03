package main.java.items;

import java.util.Random;

public class ItemGeneration {

    private String[] brandNameArray = new String[] {"AMD", "Nvidia", "Intel", "Lxino"};
    private String[] modelNameArray = new String[] {"100", "300", "400", "600", "700", "900"};
    private String[] colourArray = new String[] {"White", "Red", "Black", "Green", "Purple"};

    public String itemBrandNameGenerate () {
        Random random = new Random();
        String brandName = brandNameArray[random.nextInt(brandNameArray.length)];
        return brandName;
    }

    public String itemModelNameGenerate () {
        Random random = new Random();
        String modelName = modelNameArray[random.nextInt(modelNameArray.length)];
        return modelName;
    }

    public String itemColourGenerate () {
        Random random = new Random();
        String colour = colourArray[random.nextInt(colourArray.length)];
        return colour;
    }

    public Item itemGenerate () {
        ItemGeneration ig = new ItemGeneration();
        Item item = null;
        item = new Computer(
                ig.itemBrandNameGenerate(),
                ig.itemModelNameGenerate(),
                ig.itemColourGenerate(),
                "2020"
        );
        return item;
    }

}
