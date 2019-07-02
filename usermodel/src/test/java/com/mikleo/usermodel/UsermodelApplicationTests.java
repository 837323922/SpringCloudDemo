package com.mikleo.usermodel;

import com.mikleo.usermodel.Dao.UserDao;
import com.mikleo.usermodel.Feign.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermodelApplicationTests {

    @Autowired
    OrderService orderService;
    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() {
//        System.out.println(orderService.findOrderByorder_id(1));

//        Gson gson = new Gson();
//        User user = userDao.getUserByuserId(1);
//        user.setUsername("test01");
//        String res =  gson.toJson(user);
//        System.out.println(res);

    }
//    {"user_id":1,"username":"test01","password":"1","sex":"1","email":"1","phone":"1","reg_time":"2019-6-27","role":0}
}
