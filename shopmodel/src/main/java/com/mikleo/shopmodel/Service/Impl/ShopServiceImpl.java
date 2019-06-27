package com.mikleo.shopmodel.Service.Impl;

import com.mikleo.shopmodel.Dao.ShopDao;
import com.mikleo.shopmodel.Model.Shop;
import com.mikleo.shopmodel.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDao shopDao;

    public Shop findshopByshop_id(int id) {
        return shopDao.findshopByshop_id(id);
    }


    public Shop findshopsByshop_name(String shopname) {
        return shopDao.findshopsByshop_name(shopname);
    }


    public void createNewshop(Shop shop) {
        shopDao.createNewshop(shop);
    }


    public void deleteshopById(int id) {
        shopDao.deleteshopById(id);
    }


    public void changeshopstock(Shop shop) {
        shopDao.changeshopstock(shop);
    }


    public void updateshopMsg(Shop shop) {
        shopDao.updateshopMsg(shop);
    }
}
