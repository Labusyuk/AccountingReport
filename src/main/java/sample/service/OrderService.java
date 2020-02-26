package sample.service;

import sample.dao.OrderDao;
import sample.model.Orders;

import java.util.List;

public class OrderService implements EntityService<Integer, Orders>{
    private OrderDao orderDao = new OrderDao();
    @Override
    public Orders findById(Integer id) {
        return orderDao.findById(id);
    }

    @Override
    public void save(Orders orders) {
        orderDao.save(orders);
    }

    @Override
    public void update(Orders orders) {
        orderDao.update(orders);
    }

    @Override
    public void delete(Orders orders) {
        orderDao.delete(orders);
    }

    @Override
    public void deleteById(Integer id) {
        Orders orders = new Orders();
        orders.setId(id);
        orderDao.delete(orders);
    }

    @Override
    public List<Orders> findAll() {
        return orderDao.findAll();
    }
}
