package sample.service;

import sample.dao.CheckDao;
import sample.model.Checks;

import java.util.List;

public class CheckService implements EntityService<Integer, Checks> {
    private CheckDao checkDao = new CheckDao();
    @Override
    public Checks findById(Integer id) {
        return checkDao.findById(id);
    }

    @Override
    public void save(Checks checks) {
        checkDao.save(checks);
    }

    @Override
    public void update(Checks checks) {
        checkDao.update(checks);
    }

    @Override
    public void delete(Checks checks) {
        checkDao.delete(checks);
    }

    @Override
    public void deleteById(Integer id) {
        Checks checks = new Checks();
        checks.setId(id);
        checkDao.delete(checks);
    }

    @Override
    public List<Checks> findAll() {
        return checkDao.findAll();
    }
}
