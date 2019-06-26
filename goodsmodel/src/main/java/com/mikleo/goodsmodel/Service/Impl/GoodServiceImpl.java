package com.mikleo.goodsmodel.Service.Impl;

import com.mikleo.goodsmodel.Dao.GoodDao;
import com.mikleo.goodsmodel.Model.Good;
import com.mikleo.goodsmodel.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    GoodDao goodDao;

    @Override
    public Good findGoodBygood_id(int id) {
        return goodDao.findGoodBygood_id(id);
    }

    @Override
    public List<Good> findGoodsByshop_id(int id) {
        return goodDao.findGoodsByshop_id(id);
    }

    @Override
    public void createNewGood(Good good) {
        goodDao.createNewGood(good);
    }

    @Override
    public void deleteGoodById(int id) {
        goodDao.deleteGoodById(id);
    }

    @Override
    public void changeGoodstock(Good good) {
        goodDao.changeGoodstock(good);
    }

    @Override
    public void updateGoodMsg(Good good) {
        goodDao.updateGoodMsg(good);
    }
}
