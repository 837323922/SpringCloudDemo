package com.mikleo.usermodel.Service;

import com.mikleo.usermodel.Model.Shop;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("shopmodel")
public interface ShopService {
    @RequestMapping(value = "/shop/{id}", method = RequestMethod.GET)
    Shop findshopByshop_id(@PathVariable int id);

    @RequestMapping(value = "/shopname/{shopname}", method = RequestMethod.GET)
    Shop findshopsByshop_name(@PathVariable String shopname);

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    String createNewshop(@RequestBody Shop shop);

    @RequestMapping(value = "/shop/{id}", method = RequestMethod.DELETE)
    String deleteshopById(@PathVariable int id);


    @RequestMapping(value = "/shop", method = RequestMethod.PATCH)
    String changeshopstock(@RequestBody Shop shop);

    @RequestMapping(value = "/shop", method = RequestMethod.PUT)
    String updateshopMsg(@RequestBody Shop shop);
}
