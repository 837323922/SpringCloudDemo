package com.mikleo.ordermodel.Service;

import com.mikleo.ordermodel.Model.Order;

import java.util.List;

public interface OrderService {

    Order findOrderByorder_id(int id);

    List<Order> findOrdersByuser_id(int id);

    void createNewOrder(Order order);

    void deleteOrderById(int id);

    void changeOrderState(Order order);

    void updateOrderMsg(Order order);
}
