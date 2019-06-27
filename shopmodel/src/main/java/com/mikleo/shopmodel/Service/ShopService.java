package com.mikleo.shopmodel.Service;

import com.mikleo.shopmodel.Model.Shop;


public interface ShopService {

    Shop findshopByshop_id(int id);

    Shop findshopsByshop_name(String shopname);

    void createNewshop(Shop shop);

    void deleteshopById(int id);

    void changeshopstock(Shop shop);

    void updateshopMsg(Shop shop);
}
