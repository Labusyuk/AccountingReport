package sample.service;

import sample.dao.ProductDao;
import sample.model.Product;

import java.util.List;

public class ProductService implements EntityService<Integer,Product> {
    private ProductDao productDao = new ProductDao();
    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    public void deleteById(Integer id) {
        Product product = new Product();
        product.setId(id);
        productDao.delete(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
