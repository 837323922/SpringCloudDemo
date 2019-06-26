package com.mikleo.shop.Service.Impl;

import com.mikleo.shop.Dao.ShopDao;
import com.mikleo.shop.Model.Shop;
import com.mikleo.shop.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDao shopDao;

    @Override
    public Shop findshopByshop_id(int id) {
        return shopDao.findshopByshop_id(id);
    }

    @Override
    public Shop findshopsByshop_name(String shopname) {
        return shopDao.findshopsByshop_name(shopname);
    }

    @Override
    public void createNewshop(Shop shop) {
        shopDao.createNewshop(shop);
    }

    @Override
    public void deleteshopById(int id) {
        shopDao.deleteshopById(id);
    }

    @Override
    public void changeshopstock(Shop shop) {
        shopDao.changeshopstock(shop);
    }

    @Override
    public void updateshopMsg(Shop shop) {
        shopDao.updateshopMsg(shop);
    }
}
