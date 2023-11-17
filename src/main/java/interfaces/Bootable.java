package interfaces;

import exceptions.ComputerIsNotOKException;
import orders.Order;

public interface Bootable {

    public abstract void boot () throws Exception;
}
