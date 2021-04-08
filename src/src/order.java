package src;

import java.util.PrimitiveIterator;

public class order extends product {
    private int STT_Order;
    private int amountOfOrder;
    private String stateOfOrder;
    private int totalOrder;
    public order () {

    }
    public order(String nameProduct, String idProduct, int price,int STT_Order, int amountOfOrder, String stateOfOrder, int totalOrder) {
        super(nameProduct, idProduct, price);
        this.STT_Order = STT_Order;
        this.amountOfOrder = amountOfOrder;
        this.stateOfOrder = stateOfOrder;
        this.totalOrder = totalOrder;
    }
    public int getTotalCost(){
        return amountOfOrder * getPrice();
    }

    public void setAmountOfOrder(int amountOfOrder) {
        this.amountOfOrder = amountOfOrder;
    }

    public void setStateOfOrder(String stateOfOrder) {
        this.stateOfOrder = stateOfOrder;
    }

    public void setSTT_Order(int STT_Order) {
        this.STT_Order = STT_Order;
    }

    public int getAmountOfOrder() {
        return amountOfOrder;
    }

    public int getSTT_Order() {
        return STT_Order;
    }

    public String getStateOfOrder() {
        return stateOfOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public int getTotalOrder() {
        return amountOfOrder * getPrice();
    }

}
