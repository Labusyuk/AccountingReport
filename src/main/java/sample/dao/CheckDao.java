package sample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.model.Checks;
import sample.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CheckDao implements EntityDao<Integer, Checks> {
    @Override
    public Checks findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Checks.class, id);
    }

    @Override
    public void save(Checks checks) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(checks);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Checks checks) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(checks);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Checks checks) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(checks);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Checks> findAll() {
        List<Checks> checks = (List<Checks>) HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return checks;
    }
}
