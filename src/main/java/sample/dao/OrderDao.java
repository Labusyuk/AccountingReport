package sample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.model.Order;
import sample.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class OrderDao implements EntityDao<Integer, Order> {
    @Override
    public Order findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Order.class, id);
    }

    @Override
    public void save(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(order);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(order);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(order);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = (List<Order>) HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return orders;
    }
}
