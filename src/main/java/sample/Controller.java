package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.model.*;
import javafx.scene.control.TableColumn;
import sample.service.*;

import java.time.LocalTime;
import java.util.Date;

public class Controller {
    /***PRODUCTS***/
    private ProductService productService = new ProductService();
    private ObservableList<Product> productList = FXCollections.observableArrayList();
    @FXML
    public TextField fieldProductId;
    @FXML
    public TextField fieldProductName;
    @FXML
    public ChoiceBox<ProductCategories> fieldProductType;
    @FXML
    public TextField fieldProductPrice;
    @FXML
    public TextField fieldProductCount;
    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<Product, Integer> idProductColumn;
    @FXML
    private TableColumn<Product, String> nameProductColumn;
    @FXML
    private TableColumn<Product, String> typeProductColumn;
    @FXML
    private TableColumn<Product, Integer> priceProductColumn;
    @FXML
    private TableColumn<Product, Integer> countProductColumn;

    /***ORDER***/
    private OrderService orderService = new OrderService();
    private ObservableList<Orders> ordersList = FXCollections.observableArrayList();
    @FXML
    public TextField fieldOrderId;
    @FXML
    public ChoiceBox<String> fieldOrderDate;
    @FXML
    public ChoiceBox<String> fieldOrderTime;
    @FXML
    public ChoiceBox<String> fieldOrderHall;
    @FXML
    public ChoiceBox<String> fieldOrderTable;
    @FXML
    public TextField fieldOrderCustomer;
    @FXML
    public TextField fieldOrderTelephone;
    @FXML
    private TableView<Orders> tableOrder;
    @FXML
    private TableColumn<Orders, Integer> idOrderColumn;
    @FXML
    private TableColumn<Orders, Date> dateOrderColumn;
    @FXML
    private TableColumn<Orders, LocalTime> timeOrderColumn;
    @FXML
    private TableColumn<Orders, Tables> hallOrderColumn;
    @FXML
    private TableColumn<Orders, Tables> tableOrderColumn;
    @FXML
    private TableColumn<Orders, String> customerOrderColumn;
    @FXML
    private TableColumn<Orders, String> telephoneOrderColumn;

    /***CHECK***/
    private ObservableList<Checks> checksList = FXCollections.observableArrayList();
    private CheckService checkService = new CheckService();
    @FXML
    public ChoiceBox fieldCheckName;
    @FXML
    public TextField fieldCheckCount;
    @FXML
    public TextField fieldCheckPrice;
    @FXML
    private TableView<Checks> tableCheck;
    @FXML
    private TableColumn<Checks, String> nameOrderColumn;
    @FXML
    private TableColumn<Checks, Integer> countOrderColumn;
    @FXML
    private TableColumn<Checks, Integer> priceOrderColumn;

    /***ProductCategories***/
    private ProductCategoriesService productCategoriesService = new ProductCategoriesService();
    private ObservableList<ProductCategories> productCategoriesList = FXCollections.observableArrayList();
    @FXML
    public TextField fieldProductCategoriesId;
    @FXML
    public TextField fieldProductCategoriesName;
    @FXML
    private TableView<ProductCategories> tableProductCategories;
    @FXML
    private TableColumn<ProductCategories, Integer> idProductCategoriesColumn;
    @FXML
    private TableColumn<ProductCategories, String> nameProductCategoriesColumn;

    /***Tables***/
    private TableService tableService = new TableService();
    private ObservableList<ProductCategories> tableList = FXCollections.observableArrayList();
    @FXML
    public TextField fieldTablesId;
    @FXML
    public TextField fieldTablesName;
    @FXML
    public TextField fieldTablesNumTables;
    @FXML
    public TextField fieldTablesPrice;
    @FXML
    private TableView<Tables> tableTables;
    @FXML
    private TableColumn<Tables, Integer> idTablesColumn;
    @FXML
    private TableColumn<Tables, String> hallTablesColumn;
    @FXML
    private TableColumn<Tables, Integer> nameNumTablesColumn;
    @FXML
    private TableColumn<Tables, String> priceTablesColumn;




    // инициализируем форму данными
    @FXML
    private void initialize() {
        initData();
        idProductColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        nameProductColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        typeProductColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        priceProductColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        countProductColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("count"));
        tableProduct.setItems(productList);

        idOrderColumn.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("id"));
        dateOrderColumn.setCellValueFactory(new PropertyValueFactory<Orders, Date>("date"));
        timeOrderColumn.setCellValueFactory(new PropertyValueFactory<Orders, LocalTime>("localTime"));
        hallOrderColumn.setCellValueFactory(new PropertyValueFactory<Orders, Tables>("table"));
        tableOrderColumn.setCellValueFactory(new PropertyValueFactory<Orders, Tables>("table"));
        customerOrderColumn.setCellValueFactory(new PropertyValueFactory<Orders, String>("сustomer"));
        telephoneOrderColumn.setCellValueFactory(new PropertyValueFactory<Orders, String>("telephone"));
        tableOrder.setItems(ordersList);

    }

    private void initData() {
        productList.addAll(productService.findAll());
        ordersList.addAll(orderService.findAll());
    }



    public void onClickProductTableView(MouseEvent mouseEvent) {
        int index = tableProduct.getSelectionModel().getSelectedIndex();
        if(index<0)return;
        fieldProductId.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getId()));
        fieldProductName.setText(tableProduct.getSelectionModel().getTableView().getItems().get(index).getName());
        ///fieldProductType.setText(tableProduct.getSelectionModel().getTableView().getItems().get(index).getType());
        fieldProductPrice.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getPrice()));
        fieldProductCount.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getCount()));
    }

    public void onClickProductApply(MouseEvent mouseEvent) {
        /*Product product = new Product(Integer.valueOf(fieldProductId.getText()),fieldProductName.getText(),fieldProductType.getText(), Integer.valueOf(fieldProductPrice.getText()),Integer.valueOf(fieldProductCount.getText()));
        if(!fieldProductId.getText().isEmpty() && productService.findById(Integer.valueOf(fieldProductId.getText()))!=null){
            productService.update(product);
        }else{
            productService.save(product);
        }
        productList.clear();
        productList.addAll(productService.findAll());*/
    }

    public void onClickProductDelete(MouseEvent mouseEvent) {
        if (!fieldProductId.getText().isEmpty() && productService.findById(Integer.valueOf(fieldProductId.getText())) != null) {

            productService.deleteById(Integer.valueOf(fieldProductId.getText()));
        }
        productList.clear();
        productList.addAll(productService.findAll());
    }

/*    public void onClickOrderApply(MouseEvent mouseEvent) {
        Order order = new Order(Integer.valueOf(fieldProductId.getText()),fieldProductName.getText(),fieldProductType.getText(), Integer.valueOf(fieldProductPrice.getText()),Integer.valueOf(fieldProductCount.getText()));
        if(!fieldProductId.getText().isEmpty() && productService.findById(Integer.valueOf(fieldProductId.getText()))!=null){
            productService.update(product);
        }else{
            productService.save(product);
        }
        productList.clear();
        productList.addAll(productService.findAll());
    }

    public void onClickOrderDelete(MouseEvent mouseEvent) {
        if (!fieldProductId.getText().isEmpty() && productService.findById(Integer.valueOf(fieldProductId.getText())) != null) {

            productService.deleteById(Integer.valueOf(fieldProductId.getText()));
        }
        productList.clear();
        productList.addAll(productService.findAll());
    }*/


}