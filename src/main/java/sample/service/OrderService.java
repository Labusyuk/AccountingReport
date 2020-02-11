package sample.service;

import sample.dao.OrderDao;
import sample.model.Check;
import sample.model.Order;

import java.util.List;

public class OrderService implements EntityService<Integer, Order>{
    private OrderDao orderDao = new OrderDao();
    @Override
    public Order findById(Integer id) {
        return orderDao.findById(id);
    }

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public void delete(Order order) {
        orderDao.delete(order);
    }

    @Override
    public void deleteById(Integer id) {
        Order order = new Order();
        order.setId(id);
        orderDao.delete(order);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }
}
