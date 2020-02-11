package sample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.model.Check;
import sample.model.Product;
import sample.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CheckDao implements EntityDao<Integer, Check> {
    @Override
    public Check findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Check.class, id);
    }

    @Override
    public void save(Check check) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(check);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Check check) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(check);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Check check) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(check);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Check> findAll() {
        List<Check> checks = (List<Check>) HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return checks;
    }
}
