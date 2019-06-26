package com.mikleo.ordermodel.Service.Impl;

import com.mikleo.ordermodel.Dao.OrderDao;
import com.mikleo.ordermodel.Model.Order;
import com.mikleo.ordermodel.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public Order findOrderByorder_id(int id) {
        return orderDao.findOrderByorder_id(id);
    }

    @Override
    public List<Order> findOrdersByuser_id(int id) {

        return orderDao.findOrdersByuser_id(id);
    }

    @Override
    public void createNewOrder(Order order) {
        orderDao.createNewOrder(order);
    }

    @Override
    public void deleteOrderById(int id) {
        orderDao.deleteOrderById(id);
    }

    @Override
    public void changeOrderState(Order order) {
        orderDao.changeOrderState(order);
    }

    @Override
    public void updateOrderMsg(Order order) {
        orderDao.updateOrderMsg(order);
    }
}
