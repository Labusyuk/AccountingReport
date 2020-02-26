package sample.service;

import sample.dao.TableDao;
import sample.model.Tables;

import java.util.List;

public class TableService implements EntityService<Integer, Tables> {
    private TableDao tableDao = new TableDao();
    @Override
    public Tables findById(Integer id) {
        return tableDao.findById(id);
    }

    @Override
    public void save(Tables product) {
        tableDao.save(product);
    }

    @Override
    public void update(Tables product) {
        tableDao.update(product);
    }

    @Override
    public void delete(Tables product) {
        tableDao.delete(product);
    }

    @Override
    public void deleteById(Integer id) {
        Tables tables = new Tables();
        tables.setId(id);
        tableDao.delete(tables);
    }

    @Override
    public List<Tables> findAll() {
        return tableDao.findAll();
    }
}
