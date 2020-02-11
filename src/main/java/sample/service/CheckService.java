package sample.service;

import sample.dao.CheckDao;
import sample.dao.ProductDao;
import sample.model.Check;
import sample.model.Product;

import java.util.List;

public class CheckService implements EntityService<Integer, Check> {
    private CheckDao checkDao = new CheckDao();
    @Override
    public Check findById(Integer id) {
        return checkDao.findById(id);
    }

    @Override
    public void save(Check check) {
        checkDao.save(check);
    }

    @Override
    public void update(Check check) {
        checkDao.update(check);
    }

    @Override
    public void delete(Check check) {
        checkDao.delete(check);
    }

    @Override
    public void deleteById(Integer id) {
        Check check = new Check();
        check.setOrder_id(id);
        checkDao.delete(check);
    }

    @Override
    public List<Check> findAll() {
        return checkDao.findAll();
    }
}
