package com.mikleo.shop.Service;

import com.mikleo.shop.Model.Shop;


public interface ShopService {

    Shop findshopByshop_id(int id);

    Shop findshopsByshop_name(String shopname);

    void createNewshop(Shop shop);

    void deleteshopById(int id);

    void changeshopstock(Shop shop);

    void updateshopMsg(Shop shop);
}
