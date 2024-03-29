package com.mikleo.goodsmodel;

import com.google.gson.Gson;
import com.mikleo.goodsmodel.Dao.GoodDao;
import com.mikleo.goodsmodel.Model.Good;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class goodsmodelApplicationTests {

    @Autowired
    GoodDao goodDao;

    @Test
    public void contextLoads() {
        Gson gson = new Gson();
        Good good = goodDao.findGoodBygood_id(1);
        System.out.println(gson.toJson(good));
    }
//    {"good_id":1,"shop_id":1,"goodname":"1","gooddesc":"1","goodprice":1.0,"goodstock":1,"salesvolume":1,"goodcreatedtime":"Nov 2, 2009 12:00:00 AM"}
}
