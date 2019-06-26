package com.mikleo.ordermodel;

import com.google.gson.Gson;
import com.mikleo.ordermodel.Dao.OrderDao;
import com.mikleo.ordermodel.Model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdermodelApplicationTests {

    @Autowired
    OrderDao OrderDao;

    @Test
    public void contextLoads() {
        Gson gson = new Gson();
        Order order = OrderDao.findOrderByorder_id(1);
        System.out.println(gson.toJson(order));
    }
}
