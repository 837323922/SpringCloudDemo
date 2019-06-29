package com.mikleo.ordermodel;

import com.google.gson.Gson;
import com.mikleo.ordermodel.Dao.OrderDao;
import com.mikleo.ordermodel.Model.Order;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdermodelApplicationTests {

    @Autowired
    OrderDao OrderDao;
    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        Get index = new Get.Builder("test",1+"").build();
        try {
            JestResult jestResult = jestClient.execute(index);
            System.out.println(jestResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Gson gson = new Gson();
//        Order order = OrderDao.findOrderByorder_id(1);
//        System.out.println(gson.toJson(order));
    }

//{"order_id":1,"good_id":1,"user_id":1,"goodname":"1","goodnum":1,"unitprice":1,"totalprice":1,"ordertime":"2009-6-11","orderstate":0,"fromaddress":"1","toaddress":"1","fromphone":"1","tophone":"1","fromname":"1","toname":"1"}

}
