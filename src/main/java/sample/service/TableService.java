package sample.service;

import sample.dao.ProductDao;
import sample.dao.TableDao;
import sample.model.Product;
import sample.model.Table;

import java.util.List;

public class TableService implements EntityService<Integer, Table> {
    private TableDao tableDao = new TableDao();
    @Override
    public Table findById(Integer id) {
        return tableDao.findById(id);
    }

    @Override
    public void save(Table product) {
        tableDao.save(product);
    }

    @Override
    public void update(Table product) {
        tableDao.update(product);
    }

    @Override
    public void delete(Table product) {
        tableDao.delete(product);
    }

    @Override
    public void deleteById(Integer id) {
        Table table = new Table();
        table.setId(id);
        tableDao.delete(table);
    }

    @Override
    public List<Table> findAll() {
        return tableDao.findAll();
    }
}
