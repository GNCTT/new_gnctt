package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import src.ControllerData;
import src.order;
import src.product;
import src.shipment;

public class Controller implements Initializable {

    //Login_var
    private Boolean Logined = false;

    @FXML
    private JFXButton Login;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton Login2;
    @FXML
    private JFXButton Close_Button;
    @FXML
    private AnchorPane Login_tab;
    @FXML
    private Label notify_login;
    @FXML
    private AnchorPane Login_tab_back;

    //forget_pass
    @FXML
    private JFXButton forget_pass;
    @FXML
    private AnchorPane notify_forget_pas;
    @FXML
    private Label content;
    @FXML
    private JFXButton Ok_button;

    @FXML
    private JFXButton Cancel;

// Menu_var

    @FXML
    private JFXButton Home;

    @FXML
    private JFXButton Order_button;

    @FXML
    private JFXButton Buy_product;

    @FXML
    private JFXButton product;

    @FXML
    private JFXButton credit;

    @FXML
    private JFXButton employees;

    @FXML
    private AnchorPane Home_1;

    @FXML
    private AnchorPane Order_tab;

    @FXML
    private AnchorPane Buy_product_1;

    @FXML
    private AnchorPane product_1;

    @FXML
    private AnchorPane credit_1;

    @FXML
    private AnchorPane employees_1;

    @FXML
    private Label LB_Name;

    //product_1_table
    @FXML
    private TableView<shipment> product_table;
    @FXML
    private TableColumn<shipment, String> macol;
    @FXML
    private TableColumn<shipment, String> tencol;
    @FXML
    private TableColumn<shipment, Integer> soluongcol;
    @FXML
    private TableColumn<shipment, Integer> giacol;
    @FXML
    private TableColumn<shipment, String> tinhtrangcol;


    //product textfield
    @FXML
    private TextField maid_pro;
    @FXML
    private TextField tenid_pro;
    @FXML
    private TextField soluongid_pro;
    @FXML
    private TextField giaid_pro;
    @FXML
    private TextField tinhtrangid_pro;

    @FXML
    private TextField search_text;

    @FXML
    private JFXButton search_button;

    private ObservableList<shipment> shipmentsList;

    //Order_var

    @FXML
    private JFXButton Order_click;

    @FXML
    private AnchorPane Order_tab_2;

    @FXML
    private TableView<order> OrDer_table;

    @FXML
    private TableColumn<order, Integer> STT_Order;

    @FXML
    private TableColumn<order, String> ID_Order;

    @FXML
    private TableColumn<order, String> Name_Order;

    @FXML
    private TableColumn<order, String> state_Order;

    @FXML
    private TableColumn<order, Integer> Price_Order;

    @FXML
    private TableColumn<order, Integer> Amount_Order;

    @FXML
    private TableColumn<order, Integer> Sum_Order;

    private ObservableList<order> ordersList;
    //pay_var_order
    @FXML
    private JFXButton Paid_button_Order;

    @FXML
    private AnchorPane Payment_tab;
    @FXML
    private JFXButton Cancel_Paid_btn;

    @FXML
    private TextField Paid_text_Order;

    @FXML
    private TextField ToTal_text_Order;

    @FXML
    private TextField ExCash_text_Order;
    // text_Order
    @FXML
    private TextField id_product_Order; //text_id

    @FXML
    private TextField number_Order; //text_so_luong

    @FXML
    private JFXButton Add_btn_Order;  // button_them

    @FXML
    private TextField Total_money_Order; // text_tong_tien



    // Signal_var
    public Boolean check_select = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ss;

        this.Login_event();
        setShipmentlistDefault();
        setOrderlistDefault();
        this.create_order();
        this.Order_event();
        this.setvalueoftable();
        this.searchinproducttable();
        this.editproducttable();
    }
    // tao gia tri cho product_table
    public void setvalueoftable(){
        macol.setCellValueFactory(new PropertyValueFactory<shipment, String>("idProduct"));
        tencol.setCellValueFactory(new PropertyValueFactory<shipment, String>("nameProduct"));
        soluongcol.setCellValueFactory(new PropertyValueFactory<shipment, Integer>("amountOfShipment"));
        giacol.setCellValueFactory(new PropertyValueFactory<shipment, Integer>("price"));
        tinhtrangcol.setCellValueFactory(new PropertyValueFactory<shipment, String>("stateOfShipment"));
        product_table.setItems(shipmentsList);
    }

    // tim kiem trong product_table
    public void searchinproducttable(){
        FilteredList<shipment> filteredData = new FilteredList<>(shipmentsList, b -> true);
        search_text.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (employee.getIdProduct().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (employee.getNameProduct().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else
                    return false; // Does not match.
            });
        });
        SortedList<shipment> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(product_table.comparatorProperty());
        product_table.setItems(sortedData);
    }


    // chinh sua trong product_table
    public void editproducttable(){
        product_table.setEditable(true);
        macol.setCellFactory(TextFieldTableCell.forTableColumn());
        tencol.setCellFactory(TextFieldTableCell.forTableColumn());
        soluongcol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        giacol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tinhtrangcol.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public ObservableList<shipment> setShipmentlistDefault(){
        shipmentsList= FXCollections.observableArrayList();
        ControllerData.testAddShipment();
        for (int i = 0; i< ControllerData.listShipment.size(); i++){
            shipmentsList.add(ControllerData.listShipment.get(i));
        }
        System.out.println(shipmentsList);
        return shipmentsList;
    }

    public ObservableList<order> setOrderlistDefault(){
        ordersList= FXCollections.observableArrayList();
        ControllerData.testAddOrder();
        for (int i = 0; i< ControllerData.listOrders.size(); i++){
            ordersList.add(ControllerData.listOrders.get(i));
        }
        System.out.println(ordersList);
        return ordersList;
    }

    public void Close_Click(AnchorPane tab, JFXButton but) {
        but.setOnMouseClicked(event -> {
            tab.setVisible(false);
        });
    }

    public void Open_Click(AnchorPane tab, JFXButton btn) {
        btn.setOnMouseClicked(event -> {
            tab.setVisible(true);
        });
    }

    public void search_Product_Click(){
        search_button.setOnMouseClicked(event -> {
            searchinproducttable();
        });
    }

    // Tab_dang_nhap

    public void Log_out() {
        Login2.setOnMouseClicked(event -> {
            Login_tab_back.setVisible(true);
            Login_tab.setVisible(true);
        });
    }
    public void Login_Forget(JFXButton login, AnchorPane Login_tab) {
        login.setOnMouseClicked(event -> {
            if (!Login_tab.isVisible()) {
                Login_tab.setVisible(true);
            } else {
                String user = username.getText();
                String pass = password.getText();
                //check_ki_tu_khi_dang_nh
                // xu_li_thong_tin_dang_nhap
                if (Check_key(user, pass, 4, 16) && (user.equals("gnctt") && pass.equals("191001"))) {

                    Login_tab.setVisible(false);
                    Login_tab_back.setVisible(false);
                    username.setText("");
                    password.setText("");
                    notify_login.setText("");
                    Logined = true;
                    if (Logined) {
                        Login2.setText("Đăng xuất");
                    } else {
                        Login2.setText("Đăng nhập");
                        //????
                    }
                } else {
                    if (!Check_key(user, pass, 4, 16)) {
                        notify_login.setText("* tài khoản mật khẩu không đúng định dạng, không \n" +
                                "chứa kí tự đặc biệt, dài hơn 4 kí tự không quá 16 kí tự");
                    } else {
                        notify_login.setText("* tài khoản hoặc mật khẩu không chính xác vui lòg nhập lại \n" + "hoặc chọn quên mật khẩu");
                    }


                }

            }
        });
        forget_pass.setOnMouseClicked(event -> {
            String user = username.getText();
            notify_forget_pas.setVisible(true);
            Close_Click(notify_forget_pas, Ok_button);
            Close_Click(notify_forget_pas, Cancel);
            if (user.equals("gnctt")) {

                content.setText("          Đã gửi mật khẩu mới\n" +
                        "            tới gmail của bạn");
            } else {
                content.setText("          tài khoản chưa tồn tại\n" +
                        "            hãy đăng kí với quản lí");
            }
        });
    }
    //


    // Kiem_tra_dinh_dang_us_ps;

    public boolean Check_space(String a) {
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) >= 65 && a.charAt(i) <= 90) || (a.charAt(i) >= 97 && a.charAt(i) <= 122) || (a.charAt(i) >= 48 && a.charAt(i) <= 57)) {

                return true;
            }
        }
        return false;
    }

    public boolean Check_key(String a, String b, int minlength, int maxlength) {
        if (a.length() <= minlength || b.length() <= minlength || a.length() >= maxlength || b.length() >= maxlength) {
            return false;
        } else {
            if (Check_space(a) && Check_space(b)) {
                return true;
            }
        }
        return false;
    }

    //get_text_khi_an_button
    public void get_Text(TextField a, TextField b, JFXButton btn) {
        btn.setOnMouseClicked(event -> {
            String a1 = a.getText();
            String b1 = b.getText();
            System.out.println(a1 + " " + b1);
        });
    }



    //Menu_
    public void handleClick(ActionEvent e) {

        if (e.getSource() == Home) {
            LB_Name.setText("trang chủ");
            Home_1.setVisible(true);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }
        if (e.getSource() == Order_button) {
            LB_Name.setText("tạo đơn hàng");
            Home_1.setVisible(false);
            Order_tab.setVisible(true);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);

            //content of orderTab
            Order_tab_2.setVisible(false);

        }
        if (e.getSource() == Buy_product) {
            LB_Name.setText("nhập lô hàng");
            Home_1.setVisible(false);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(true);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }
//<<<<<<< Updated upstream
        if (e.getSource() == product) {
            LB_Name.setText("sản phẩm");
            Home_1.setVisible(false);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(true);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }

        if (e.getSource() == employees) {
            LB_Name.setText("nhân viên");
            Home_1.setVisible(false);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(true);
        }
//=======
        if (e.getSource() == product) {
            LB_Name.setText("sản phẩm");
            Home_1.setVisible(false);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(true);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }

        if (e.getSource() == employees) {
            LB_Name.setText("nhân viên");
            Home_1.setVisible(false);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(true);
        }
//>>>>>>> Stashed changes
        if (e.getSource() ==credit) {
            LB_Name.setText("thẻ tín dụng");
            Home_1.setVisible(false);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(true);
            employees_1.setVisible(false);
        }
    }

    //Login_tab
    public void Login_event() {
        Login_Forget(Login, Login_tab);
        Log_out();
    }

    //Order_tab
    public void Order_event() {
        //mo_tab_tao_don_hang
        Open_Click(Order_tab_2, Order_click);
        //tab_thanh_toan
        Open_Click(Payment_tab, Paid_button_Order);
        Close_Click(Payment_tab,Cancel_Paid_btn );
        ToTal_text_Order.setText("gnctt");
        ToTal_text_Order.setEditable(false);
        ExCash_text_Order.setEditable(false);
        get_Text(id_product_Order, number_Order, Add_btn_Order);
        //endm
    }

    //product_event
    // su kien Add de them san pham
    public void add (ActionEvent e){
        shipment newshipment = new shipment();
        newshipment.setIdProduct(maid_pro.getText());
        newshipment.setNameProduct(tenid_pro.getText());
        newshipment.setAmountOfShipment(Integer.parseInt(soluongid_pro.getText()));
        newshipment.setPrice(Integer.parseInt(giaid_pro.getText()));
        newshipment.setStateOfShipment(tinhtrangid_pro.getText());
        shipmentsList.add(newshipment);
    }
    // su kien delete de xoa san pham

    public void delete(ActionEvent e){
        //  productsList.remove(products.getSelectionModel().getSelectedItem());
        shipment selected = product_table.getSelectionModel().getSelectedItem();
        shipmentsList.remove(selected);
    }
    //create-Order
    public void create_order() {
        STT_Order.setCellValueFactory(new PropertyValueFactory<order, Integer>("STT_Order"));
        ID_Order.setCellValueFactory(new PropertyValueFactory<order, String>("idProduct"));
        Name_Order.setCellValueFactory(new PropertyValueFactory<order, String>("nameProduct"));
        state_Order.setCellValueFactory(new PropertyValueFactory<order, String>("stateOfOrder"));
        Price_Order.setCellValueFactory(new PropertyValueFactory<order, Integer>("price"));
        Amount_Order.setCellValueFactory(new PropertyValueFactory<order, Integer>("amountOfOrder"));
        Sum_Order.setCellValueFactory(new PropertyValueFactory<order, Integer>("totalOrder"));
        OrDer_table.setItems(ordersList);
    }

    public void add_Order (ActionEvent e){
        order neworder = new order();
        neworder.setIdProduct(id_product_Order.getText());
        neworder.setNameProduct("bim bim"); // phu thuoc vao id
        neworder.setAmountOfOrder(Integer.parseInt(number_Order.getText()));
        neworder.setPrice(100); // phu thuoc vao id
        neworder.setStateOfOrder("con"); // lay trong tung ban ghi phu thuoc vao id product
        neworder.setSTT_Order(3); // set_stt
        neworder.setTotalOrder(Integer.parseInt(number_Order.getText()) * 100);
        ordersList.add(neworder);
    }

    public void delete_Order(ActionEvent e){
        //  productsList.remove(products.getSelectionModel().getSelectedItem());
        order selected = OrDer_table.getSelectionModel().getSelectedItem();
        ordersList.remove(selected);
    }


}
