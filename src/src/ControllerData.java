package src;

import java.util.ArrayList;
import java.util.Collections;

public class ControllerData {

    public static ArrayList<product> listProducts = new ArrayList<product>();
    public static ArrayList<user> listUsers= new ArrayList<user>();
    public static ArrayList<bill> listRemainingBill= new ArrayList<bill>();
    public static ArrayList<shipment> listShipment = new ArrayList<>();
    public static ArrayList<order> listOrders = new ArrayList<>();

    public static void testAddShipment(){
        shipment a=new shipment("bim bim","awdawd",5, 100, "còn hàng");
        shipment b= new shipment("sua","sgdirgsjif",7, 200, "còn hàng");
        shipment c= new shipment ("mitom","cbakcawd",4, 101, "hết hàng");
        ControllerData.listShipment.add(a);
        ControllerData.listShipment.add(b);
        ControllerData.listShipment.add(c);
        System.out.println("123"+ControllerData.listShipment);
    }

    public static void testAddOrder(){
        order a=new order("bim bim","awdawd",5,1, 100, "còn hàng", 5 * 100);
        order b=new order("sua","sfg",5,1, 100, "còn hàng", 5 * 100);
        order c=new order("mi tom","bjh",5,1, 100, "còn hàng", 5 * 100);
        ControllerData.listOrders.add(a);
        ControllerData.listOrders.add(b);
        ControllerData.listOrders.add(c);
    }

    public static void sortListProducts(){
        Collections.sort(listProducts,(pro1,pro2)-> pro1.compareTo(pro2));
    }
    public static void sortListUser(){
        Collections.sort(listUsers,(user1,user2)->user1.compareTo(user2));
    }
    public static void sortListShipment(){
        Collections.sort(listShipment,(ship1,ship2)-> ship1.compareTo(ship2));
    }

    public static void addProduct(product Product){
        ControllerData.listProducts.add(Product);
        sortListProducts();
    }

    public static void addShipment(shipment Shipment){
        ControllerData.listShipment.add(Shipment);
        sortListShipment();
    }
    public static void addUser(user User){
        ControllerData.listUsers.add(User);
        sortListUser();
    }
//    public static boolean addShipmentOfProduct(product Product,shipment Shipment){
//        for(int i = 0; i< ControllerData.listProducts.size(); i++){
//            if(ControllerData.listProducts.get(i).getIdProduct()==Product.getIdProduct() )
//            {
//                ControllerData.listProducts.get(i).addShipment(Shipment);
//                return true;
//            }
//        }
//        return false;
//    }

    public static void createBill(ArrayList<order> Orders,String idBill){
        bill Bill =new bill(idBill);
        for(int i=0;i<Orders.size();i++)
        {
            Bill.addOrders(Orders.get(i));
        }
        ControllerData.listRemainingBill.add(Bill);
    }

    public static boolean payBill(bill Bill){
        for (int i = 0; i< ControllerData.listRemainingBill.size(); i++){
            if(ControllerData.listRemainingBill.get(i).getIdBill()== Bill.getIdBill())
            {
                ControllerData.listRemainingBill.remove(i);
                return true;
            }
        }
        return false;
    }
}
