package com.mikleo.ordermodel.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.mikleo.ordermodel.Model.Order;
import com.mikleo.ordermodel.Service.OrderService;
import io.searchbox.annotations.JestId;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.Update;
import io.searchbox.indices.mapping.PutMapping;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    JestClient jestClient;

    @Autowired
    OrderService orderService;

    private String indexName = "test";
    private String typeName = "order";
    private Gson gson = new Gson();

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order findOrderByorder_id(@PathVariable int id) {
        return orderService.findOrderByorder_id(id);
    }

    @RequestMapping("/order/es/{id}")
    public Order es_findOrderByorder_id(@PathVariable int id) {
        String json = "{\n" +
                "  \"query\" : { \"match\" : { \"order_id\" : \"" + id + "\" }}\n" +
                "}'";
        Search search = new Search.Builder(json).build();
        Order order = new Order();
        try {
            JestResult jestResult = jestClient.execute(search);
            order = gson.fromJson(jestResult.getJsonString(), Order.class);
            return order;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return order;
    }

    @RequestMapping(value = "/order/findbyuser/{id}", method = RequestMethod.GET)
    public List<Order> findOrdersByuser_id(@PathVariable int id) {
        return orderService.findOrdersByuser_id(id);
    }

    @RequestMapping("/order/es/findbyuser/{id}")
    public List<Order> es_findOrderByuser_id(@PathVariable int id) {
        String json = "{\n" +
                "  \"query\" : { \"match\" : { \"user_id\" : \"" + id + "\" }}\n" +
                "}'";
        Search search = new Search.Builder(json).build();
        List<Order> orders = new ArrayList<>();
        try {
            JestResult jestResult = jestClient.execute(search);
            JsonArray jsonElements = gson.fromJson(jestResult.getJsonString(), JsonArray.class);
            for (JsonElement jsonElement:jsonElements){
                orders.add(gson.fromJson(jsonElement,Order.class));
            }
            return orders;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String createNewOrder(@RequestBody Order order) {
        Index index = new Index.Builder(order).index(indexName).type(typeName).build();
        orderService.createNewOrder(order);
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "创建完成";
    }


    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public String deleteOrderBy(@PathVariable int id) {
        Delete delete = new Delete.Builder(id + "").index(indexName).type(typeName).build();
        orderService.deleteOrderById(id);
        try {
            jestClient.execute(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除完成";
    }


    @RequestMapping(value = "/order", method = RequestMethod.PATCH)
    public String changeOrderState(@RequestBody Order order) {
        orderService.changeOrderState(order);
        Update update = new Update.Builder(order).index(indexName).type(typeName).build();
        try {
            jestClient.execute(update);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "订单完成";
    }


    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String updateOrderMsg(@RequestBody Order order) {
        orderService.updateOrderMsg(order);
        Update update = new Update.Builder(order).index(indexName).type(typeName).build();
        try {
            jestClient.execute(update);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "信息更新完成";
    }
}

