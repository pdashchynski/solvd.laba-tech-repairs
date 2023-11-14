package main.java.interfaces;

import main.java.exceptions.ComputerIsNotOKException;
import main.java.orders.Order;

public interface Bootable {

    public abstract void boot () throws Exception;
}
