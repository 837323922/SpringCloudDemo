package com.mikleo.usermodel.Feign;

import com.mikleo.usermodel.Config.FooCofing;
import com.mikleo.usermodel.Model.Order;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "service-ordermodel")
public interface OrderService {

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    Order findOrderByorder_id(@PathVariable("id") int id);


    @RequestMapping(value = "/order/findbyuser/{id}", method = RequestMethod.GET)
    List<Order> findOrdersByuser_id(@PathVariable("id") int id);


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    String createNewOrder(@RequestBody Order order);


    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    String deleteOrderBy(@PathVariable("id") int id);


    @RequestMapping(value = "/order", method = RequestMethod.PATCH)
    String changeOrderState(@RequestBody Order order);


    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    String updateOrderMsg(@RequestBody Order order);

}
