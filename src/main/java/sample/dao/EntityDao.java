package sample.dao;

import java.util.List;

public interface EntityDao <K,T> {
    T findById(K id);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();

}
