package sample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.model.Product;
import sample.model.Table;
import sample.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TableDao implements EntityDao<Integer, Table> {

    @Override
    public Table findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Table.class, id);
    }

    @Override
    public void save(Table table) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(table);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Table table) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(table);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Table table) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(table);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Table> findAll() {
        List<Table> tables = (List<Table>) HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return tables;
    }
}
