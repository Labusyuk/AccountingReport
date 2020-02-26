package sample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sample.model.Tables;
import sample.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TableDao implements EntityDao<Integer, Tables> {

    @Override
    public Tables findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Tables.class, id);
    }

    public List<Tables> findByHall(String hall){
        Query<Tables> query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Table t where t.hall=:hall", Tables.class);
        query.setParameter("hall", hall);
        return query.list();
    }

    public Tables findByHallAndNameNum(String hall, String nameNum){
        Query<Tables> query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Table t where t.hall=:hall and t.nameNum=:nameNum", Tables.class);
        query.setParameter("hall", hall);
        query.setParameter("nameNum", nameNum);
        return query.uniqueResult();
    }

    @Override
    public void save(Tables tables) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(tables);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Tables tables) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(tables);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Tables tables) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(tables);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Tables> findAll() {
        List<Tables> tables = (List<Tables>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Tables").list();;
        return tables;
    }
}
