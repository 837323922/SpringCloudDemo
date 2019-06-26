package com.mikleo.shop.Controller;

import com.mikleo.shop.Model.Shop;
import com.mikleo.shop.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/shop/{id}", method = RequestMethod.GET)
    public Shop findshopByshop_id(@PathVariable int id) {
        return shopService.findshopByshop_id(id);
    }

    @RequestMapping(value = "/shopname/{shopname}", method = RequestMethod.GET)
    public Shop findshopsByshop_name(@PathVariable String shopname) {
        return shopService.findshopsByshop_name(shopname);
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public String createNewshop(@RequestBody Shop shop) {
        shop.setAccumulatepoint(0);
        shop.setShoprank("铜");
        shop.setShopcreatedtime(new Date());
        shopService.createNewshop(shop);
        return "商家创建成功";
    }

    @RequestMapping(value = "/shop", method = RequestMethod.DELETE)
    public String deleteshopById(int id) {
        shopService.deleteshopById(id);
        return "删除成功";
    }

    @RequestMapping(value = "/shop", method = RequestMethod.PATCH)
    public String changeshopstock(Shop shop) {
        shopService.changeshopstock(shop);
        return "商家积分修改成功";
    }

    @RequestMapping(value = "/shop", method = RequestMethod.PUT)
    public String updateshopMsg(Shop shop) {
        shopService.updateshopMsg(shop);
        return "修改成功";
    }
}
