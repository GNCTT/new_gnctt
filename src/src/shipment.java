package src;


public class shipment extends product{
//    private String nameProduct;
//    private String idProduct;
//    private double price;
    private int amountOfShipment;
    private String stateOfShipment;
//    private date receptionDate;
//    private date expirationDate;
//    private String shipmentID; //             id_ship
    public shipment( String nameProduct,String idProduct,int price,  int amountOfShipment, String stateOfShipment){
//        this.shipmentID=shipmentID;
        super(idProduct, nameProduct, price);
        this.amountOfShipment = amountOfShipment;
        this.stateOfShipment = stateOfShipment;
//        this.receptionDate= new date(receptionDate);
//        this.expirationDate=new date(expirationDate);
    }

    public shipment() {

    }

//    public date getExpirationDate() {
//        return expirationDate;
//    }
//
//    public date getReceptionDate() {
//        return receptionDate;
//    }

    public int getAmountOfShipment() {
        return amountOfShipment;
    }

    public void setAmountOfShipment(int amountOfShipment) {
        this.amountOfShipment = amountOfShipment;
    }

    public String getStateOfShipment() {
        return stateOfShipment;
    }

    public void setStateOfShipment(String stateOfShipment) {
        this.stateOfShipment = stateOfShipment;
    }
    //    public String getShipmentID() {
//        return shipmentID;
//    }


}
