package interfaces;

import orders.Order;

public interface Payable {

    public abstract void payExtra (Order order);
}
