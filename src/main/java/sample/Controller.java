package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.dao.ProductDao;
import sample.model.Product;
import javafx.scene.control.TableColumn;
public class Controller {

    @FXML
    public TextField fieldId;
    @FXML
    public TextField fieldName;
    @FXML
    public TextField fieldType;
    @FXML
    public TextField fieldWholesalePrice;
    @FXML
    public TextField fieldRetailPrice;
    @FXML
    public TextField fieldProvider;
    @FXML
    public TextField fieldCount;
    ProductDao productDao = new ProductDao();
    private ObservableList<Product> productList = FXCollections.observableArrayList();
    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> typeColumn;
    @FXML
    private TableColumn<Product, Integer> wholesalePriceColumn;
    @FXML
    private TableColumn<Product, Integer> retailPriceColumn;
    @FXML
    private TableColumn<Product, String> providerColumn;
    @FXML
    private TableColumn<Product, Integer> countColumn;


    // инициализируем форму данными
    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        wholesalePriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("wholesale_price"));
        retailPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("retail_price"));
        providerColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("provider_id"));
        countColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("count"));



        // заполняем таблицу данными
        tableProduct.setItems(productList);

    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {

        productList.addAll(productDao.getAll());

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
        fieldId.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getId()));
        fieldName.setText(tableProduct.getSelectionModel().getTableView().getItems().get(index).getName());
        fieldType.setText(tableProduct.getSelectionModel().getTableView().getItems().get(index).getType());
        fieldRetailPrice.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getRetail_price()));
        fieldWholesalePrice.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getWholesale_price()));
        fieldProvider.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getProvider_id()));
        fieldCount.setText(Integer.toString(tableProduct.getSelectionModel().getTableView().getItems().get(index).getCount()));
    }

    public void onClickApply(MouseEvent mouseEvent) {
        Product product = new Product(Integer.valueOf(fieldId.getText()),fieldName.getText(),fieldType.getText(), Integer.valueOf(fieldWholesalePrice.getText()),Integer.valueOf(fieldRetailPrice.getText()),Integer.valueOf(fieldProvider.getText()),Integer.valueOf(fieldCount.getText()));
        if(!fieldId.getText().isEmpty() && productDao.findByID(Integer.valueOf(fieldId.getText()))!=null){
            productDao.updateProduct(product);
        }else{
            productDao.create(product);
        }
        productList.clear();
        productList.addAll(productDao.getAll());

    }

    public void onClickDelete(MouseEvent mouseEvent) {
        if (!fieldId.getText().isEmpty() && productDao.findByID(Integer.valueOf(fieldId.getText())) != null) {
            productDao.deleteById(Integer.valueOf(fieldId.getText()));
        }
        productList.clear();
        productList.addAll(productDao.getAll());
    }
}