package com.mikleo.usermodel.Service;

import com.mikleo.usermodel.Model.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("service-ordermodel")
public interface OrderService {

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    Order findOrderByorder_id(@PathVariable int id);


    @RequestMapping(value = "/order/findbyuser/{id}", method = RequestMethod.GET)
    List<Order> findOrdersByuser_id(@PathVariable int id);


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    String createNewOrder(@RequestBody Order order);


    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    String deleteOrderBy(@PathVariable int id);


    @RequestMapping(value = "/order", method = RequestMethod.PATCH)
    String changeOrderState(@RequestBody Order order);


    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    String updateOrderMsg(@RequestBody Order order);


}
