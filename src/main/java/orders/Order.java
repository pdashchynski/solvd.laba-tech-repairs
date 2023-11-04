package main.java.orders;

import main.java.items.Computer;
import main.java.items.SparePart;
import main.java.persons.Client;
import main.java.persons.Master;
import main.java.services.Service;

import java.util.ArrayList;

public class Order {

    private Client client;
    private Computer computer;
    private Master master;
    private Service service;
    private ArrayList<SparePart> sparePartList;

    public Order () {}

    public Order (Client client, Computer computer, Master master, Service service) {
        this.client = client;
        this.computer = computer;
        this.master = master;
        this.service = service;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
