package com.mikleo.usermodel.Service;

import com.mikleo.usermodel.Model.Good;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("service-goodsmodel")
public interface GoodService {
    @RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
    Good findGoodByGood_id(@PathVariable int id);

    @RequestMapping(value = "/good/findbyuser/{id}", method = RequestMethod.GET)
    List<Good> findGoodsByuser_id(@PathVariable int id);


    @RequestMapping(value = "/good", method = RequestMethod.POST)
    String createNewGood(@RequestBody Good good);


    @RequestMapping(value = "/good/{id}", method = RequestMethod.DELETE)
    String deleteGoodById(@PathVariable int id);


    @RequestMapping(value = "/good", method = RequestMethod.PATCH)
    String changeGoodState(@RequestBody Good good);


    @RequestMapping(value = "/good", method = RequestMethod.PUT)
    String updateGoodMsg(@RequestBody Good good);
}
