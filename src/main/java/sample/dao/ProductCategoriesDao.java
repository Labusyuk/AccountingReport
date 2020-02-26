package sample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.model.ProductCategories;
import sample.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductCategoriesDao implements EntityDao<Integer, ProductCategories> {
    @Override
    public ProductCategories findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ProductCategories.class, id);
    }

    @Override
    public void save(ProductCategories productCategories) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(productCategories);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(ProductCategories productCategories) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(productCategories);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(ProductCategories productCategories) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(productCategories);
        tx1.commit();
        session.close();
    }

    @Override
    public List<ProductCategories> findAll() {
        List<ProductCategories> productCategories = (List<ProductCategories>) HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return productCategories;
    }
}
