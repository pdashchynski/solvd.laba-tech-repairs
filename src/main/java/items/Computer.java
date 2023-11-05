package main.java.items;

import java.util.ArrayList;
import java.util.Objects;

public class Computer extends Item {

    private ArrayList<SparePart> sparePartList = new ArrayList<SparePart>();

    public Computer() {}

    public Computer(String brandName, String modelName, String colour, String manufactureDate) {
        super(brandName, modelName, colour, manufactureDate);
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

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Computer computer = (Computer) o;
        return Objects.equals(sparePartList, computer.sparePartList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sparePartList);
    }
}
