package sample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.model.Orders;
import sample.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class OrderDao implements EntityDao<Integer, Orders> {
    @Override
    public Orders findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Orders.class, id);
    }

    @Override
    public void save(Orders orders) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(orders);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Orders orders) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(orders);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Orders orders) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(orders);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Orders> findAll() {
        List<Orders> orders = (List<Orders>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Orders").list();;
        return orders;
    }
}
