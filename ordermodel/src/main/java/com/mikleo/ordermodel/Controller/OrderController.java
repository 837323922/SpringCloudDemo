package com.mikleo.ordermodel.Controller;

import com.mikleo.ordermodel.Model.Order;
import com.mikleo.ordermodel.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order findOrderByorder_id(@PathVariable  int id) {
        return orderService.findOrderByorder_id(id);
    }


    @RequestMapping(value = "/order/findbyuser/{id}", method = RequestMethod.GET)
    public List<Order> findOrdersByuser_id(@PathVariable int id) {
        return orderService.findOrdersByuser_id(id);
    }


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String createNewOrder(@RequestBody Order order) {
        orderService.createNewOrder(order);
        return "创建完成";
    }


    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public String deleteOrderBy(@PathVariable int id) {
        orderService.deleteOrderById(id);
        return "删除完成";
    }


    @RequestMapping(value = "/order", method = RequestMethod.PATCH)
    public String changeOrderState(@RequestBody Order order) {
        orderService.changeOrderState(order);
        return "订单完成";
    }


    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String updateOrderMsg(@RequestBody Order order) {
        orderService.updateOrderMsg(order);
        return "信息更新完成";
    }


}

