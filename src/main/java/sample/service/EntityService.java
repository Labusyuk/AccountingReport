package sample.service;

import java.util.List;

public interface EntityService <K,T> {
    T findById(K id);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    void deleteById(K id);
    List<T> findAll();

}
