package com.mikleo.goodsmodel.Service;

import com.mikleo.goodsmodel.Model.Good;

import java.util.List;

public interface GoodService {

    Good findGoodBygood_id(int id);

    List<Good> findGoodsByshop_id(int id);

    void createNewGood(Good good);

    void deleteGoodById(int id);

    void changeGoodstock(Good good);

    void updateGoodMsg(Good good);
}
