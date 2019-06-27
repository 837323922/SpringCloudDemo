package com.mikleo.shopmodel;

import com.google.gson.Gson;
import com.mikleo.shopmodel.Dao.ShopDao;
import com.mikleo.shopmodel.Model.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

    @Autowired
    ShopDao shopDao;

    @Test
    public void contextLoads() {
        Gson gson = new Gson();
        Shop shop = shopDao.findshopByshop_id(1);
        System.out.println(gson.toJson(shop));
    }
//    {"shop_id":1,"shopname":"1","shopcreatedtime":"Jun 1, 2019 1:14:44 PM","accumulatepoint":1,"shoprank":"1","shopaddress":"1"}
}
