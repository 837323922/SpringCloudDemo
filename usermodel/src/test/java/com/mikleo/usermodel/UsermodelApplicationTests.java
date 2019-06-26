package com.mikleo.usermodel;

import com.google.gson.Gson;
import com.mikleo.usermodel.Dao.UserDao;
import com.mikleo.usermodel.Model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermodelApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() {
        Gson gson = new Gson();
        User user = userDao.getUserByuserId(1);
        user.setUsername("test01");

        String res =  gson.toJson(user);
        System.out.println(res);

    }

}
