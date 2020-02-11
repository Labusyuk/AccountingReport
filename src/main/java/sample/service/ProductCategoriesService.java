package sample.service;

import sample.dao.ProductCategoriesDao;
import sample.model.ProductCategories;

import java.util.List;

public class ProductCategoriesService implements EntityService<Integer, ProductCategories> {
    private ProductCategoriesDao productCategoriesDao = new ProductCategoriesDao();
    @Override
    public ProductCategories findById(Integer id) {
        return productCategoriesDao.findById(id);
    }

    @Override
    public void save(ProductCategories entity) {
        productCategoriesDao.save(entity);
    }

    @Override
    public void update(ProductCategories entity) {
        productCategoriesDao.update(entity);
    }

    @Override
    public void delete(ProductCategories entity) {
        productCategoriesDao.delete(entity);
    }

    @Override
    public void deleteById(Integer id) {
        ProductCategories productCategories = new ProductCategories();
        productCategories.setId(id);
        productCategoriesDao.delete(productCategories);
    }

    @Override
    public List<ProductCategories> findAll() {
        return productCategoriesDao.findAll();
    }
}
