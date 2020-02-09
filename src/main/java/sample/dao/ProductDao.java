package sample.dao;

import sample.db.ConnectionPool;
import sample.model.Product;
import sample.model.Provider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private ConnectionPool pool = ConnectionPool.getInstance();
    private final String INSERT_PRODUCT= "INSERT INTO trade_report.product (id, name, type, wholesale_price, retail_price, provider_id, count) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_ALL_PRODUCT= "SELECT * FROM trade_report.product";
    private final String DELETE_PRODUCT= "DELETE FROM trade_report.product WHERE id=?";
    private final String UPDATE_PRODUCT= "UPDATE trade_report.product SET name=?, type=?, wholesale_price=?, retail_price=?, provider_id=?, count=? WHERE ID=?";
    private final String SELECT_PRODUCT_BY_ID = "SELECT * FROM trade_report.product WHERE id=?";

    public Integer create(Product product) {
        int idUser = 0;
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setString(3, String.valueOf(product.getType()));
            statement.setInt(4, product.getWholesale_price());
            statement.setInt(5, product.getRetail_price());
            statement.setInt(6, product.getProvider_id());
            statement.setInt(7, product.getCount());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next())
                idUser = resultSet.getInt(1);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUser;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = pool.takeConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = retrieveEntity(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product findByID(int id){
        Product product = null;
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = retrieveEntity(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public boolean updateProduct(Product product){
        int idUser = 0;
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setString(2, String.valueOf(product.getType()));
            statement.setInt(3, product.getWholesale_price());
            statement.setInt(4, product.getRetail_price());
            statement.setInt(5, product.getProvider_id());
            statement.setInt(6, product.getCount());
            statement.setInt(7, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true; ///fix this shit;
    }

    public void deleteById(Integer id) {
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product retrieveEntity(ResultSet resultSet) {
        Product product = new Product();
        try{
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setType(resultSet.getString("type"));
            product.setWholesale_price(resultSet.getInt("wholesale_price"));
            product.setRetail_price(resultSet.getInt("retail_price"));
            product.setProvider_id(resultSet.getInt("provider_id"));
            product.setCount(resultSet.getInt("count"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

}
