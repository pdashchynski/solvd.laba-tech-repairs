package main.java.items;

import java.util.ArrayList;

public class Computer extends Item {

    private ArrayList<SparePart> sparePartList = new ArrayList<SparePart>();

    public Computer() {}

    public Computer(String brandName, String modelName, String colour, String manufactureDate) {
        super(brandName, modelName, colour, manufactureDate);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public ArrayList<SparePart> getSparePartList() {
        return sparePartList;
    }

    public void setSparePartList(ArrayList<SparePart> sparePartList) {
        this.sparePartList = sparePartList;
    }

    public void addSparePartToSparePartList(SparePart sparePart) {
        this.sparePartList.add(sparePart);
    }
}
