package com.mikleo.goodsmodel.Controller;

import com.mikleo.goodsmodel.Model.Good;
import com.mikleo.goodsmodel.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class GoodController {

    @Autowired
    GoodService goodService;

    @RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
    public Good findGoodByGood_id(@PathVariable int id) {
        return goodService.findGoodBygood_id(id);
    }


    @RequestMapping(value = "/good/findbyuser/{id}", method = RequestMethod.GET)
    public List<Good> findGoodsByuser_id(@PathVariable int id) {
        return goodService.findGoodsByshop_id(id);
    }


    @RequestMapping(value = "/good", method = RequestMethod.POST)
    public String createNewGood(@RequestBody Good good) {
        goodService.createNewGood(good);
        return "创建完成";
    }


    @RequestMapping(value = "/good/{id}", method = RequestMethod.DELETE)
    public String deleteGoodById(@PathVariable int id) {
        goodService.deleteGoodById(id);
        return "删除完成";
    }


    @RequestMapping(value = "/good", method = RequestMethod.PATCH)
    public String changeGoodState(@RequestBody Good good) {
        goodService.changeGoodstock(good);
        return "库存改变完成";
    }


    @RequestMapping(value = "/good", method = RequestMethod.PUT)
    public String updateGoodMsg(@RequestBody Good good) {
        good.setGoodupdatetime(new java.sql.Date(new Date().getTime()));
        goodService.updateGoodMsg(good);
        return "信息更新完成";
    }
}
