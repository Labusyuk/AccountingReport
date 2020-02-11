package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.dao.ProductDao;
import sample.model.*;
import javafx.scene.control.TableColumn;
import sample.service.OrderService;
import sample.service.ProductService;

public class Controller {
    /***PRODUCTS***/
    private ProductService productService = new ProductService();
    private ObservableList<Product> productList = FXCollections.observableArrayList();
    @FXML
    public TextField fieldProductId;
    @FXML
    public TextField fieldProductName;
    @FXML
    public TextField fieldProductType;
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
    private ObservableList<Order> orderList = FXCollections.observableArrayList();

    private ObservableList<Check> checkList = FXCollections.observableArrayList();
    private ObservableList<ProductCategories> productCategoriesList = FXCollections.observableArrayList();
    private ObservableList<Table> tableList = FXCollections.observableArrayList();




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
    }

    private void initData() {
        productList.addAll(productService.findAll());

/*
        productList.add(new Product(1, "Xiaomi A1","Телефон",500,600,0,1));
        productList.add(new Product(2, "Samsung Galaxy S5","Телефон",800,100,0,1));
        productList.add(new Product(3, "Iphone XS", "Телефон", 1000,1200,0,1));
        productList.add(new Product(4, "Nokia", "Телефон", 20,21,0,1));
        productList.add(new Product(5, "Samsung HotBench", "Мікрохвильова піч", 1000,1200,0,1));
        for(Product product:productList)
            productDao.create(product);
*/
    }

    public void onClickTableView(MouseEvent mouseEvent) {
        int index = tableProduct.getSelectionModel().getSelectedIndex();
        if(index<0)return;
        fieldProductId.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getId()));
        fieldProductName.setText(tableProduct.getSelectionModel().getTableView().getItems().get(index).getName());
        fieldProductType.setText(tableProduct.getSelectionModel().getTableView().getItems().get(index).getType());
        fieldProductPrice.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getPrice()));
        fieldProductCount.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getCount()));
    }

    public void onClickApply(MouseEvent mouseEvent) {
        Product product = new Product(Integer.valueOf(fieldProductId.getText()),fieldProductName.getText(),fieldProductType.getText(), Integer.valueOf(fieldProductPrice.getText()),Integer.valueOf(fieldProductCount.getText()));
        if(!fieldProductId.getText().isEmpty() && productService.findById(Integer.valueOf(fieldProductId.getText()))!=null){
            productService.update(product);
        }else{
            productService.save(product);
        }
        productList.clear();
        productList.addAll(productService.findAll());
    }

    public void onClickDelete(MouseEvent mouseEvent) {
        if (!fieldProductId.getText().isEmpty() && productService.findById(Integer.valueOf(fieldProductId.getText())) != null) {

            productService.deleteById(Integer.valueOf(fieldProductId.getText()));
        }
        productList.clear();
        productList.addAll(productService.findAll());
    }
}