package src;

import java.awt.*;
import java.util.ArrayList;

public class product {

    private String idProduct;
    private String nameProduct;
    private int price;
//    private int numberOfProduct;
//    private String state;
//    private ArrayList<shipment> listShipment  ;
    public product (String nameProduct,String idProduct,int price){
        this.nameProduct=nameProduct;
        this.idProduct=idProduct;
        this.price=price;
//        this.listShipment=new ArrayList<shipment>();
//        this.numberOfProduct =0;
//        this.state="Het hang";
    }
    public product(product Product){
        this.nameProduct=Product.nameProduct;
        this.idProduct=Product.idProduct;
        this.price =Product.price;
//        this.listShipment=Product.listShipment;
//        this.numberOfProduct=Product.numberOfProduct;
//        this.state=Product.state;
    }
//    public void addShipment(shipment Shipment){
//        listShipment.add(Shipment);
//        this.numberOfProduct =this.numberOfProduct +Shipment.getAmountOfProduct();
//        if (this.numberOfProduct != 0) this.state="Con hang";
//        else this.state="Het hang";
//    }

    public product() {
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public void setNumberOfProduct(int numberOfProduct) {
//        this.numberOfProduct = numberOfProduct;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public ArrayList<shipment> getListShipment() {
//        return listShipment;
//    }
//
//    public void setListShipment(ArrayList<shipment> listShipment) {
//        this.listShipment = listShipment;
//    }
//
//    public int getNumberOfProduct() {
//        return numberOfProduct;
//    }

    public int getPrice() {
        return price;
    }

//    public String getState123() {
//        return state;
//    }

    public String getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int compareTo(product x){
        return this.nameProduct.compareTo(x.nameProduct);
    }
}
