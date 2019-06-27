package com.mikleo.goodsmodel.Dao;

import com.mikleo.goodsmodel.Model.Good;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodDao {
    @Select("SELECT * FROM Goods WHERE good_id = #{id}")
    Good findGoodBygood_id(int id);

    @Select("SELECT * FROM Goods WHERE shop_id = #{id}")
    List<Good> findGoodsByshop_id(int id);


    @Insert("INSERT INTO Goods VALUES(null,#{shop_id},#{goodname},#{gooddesc},#{goodprice},#{goodstock}," +
            "#{salesvolume},#{goodcreatedtime},#{goodupdatetime})")
    void createNewGood(Good good);

    @Delete("Delete FROM Goods WHERE good_id=#{id}")
    void deleteGoodById(int id);

    @Update("UPDATE Goods SET goodstock=#{goodstock} WHERE good_id = #{good_id}")
    void changeGoodstock(Good good);

    @Update("UPDATE Goods SET goodname=#{goodname},gooddesc=#{gooddesc},goodprice=#{goodprice},goodstock=#{goodstock}," +
            "salesvolume=#{salesvolume},goodcreatedtime = #{goodcreatedtime},goodupdatetime = #{goodupdatetime}" +
            "WHERE good_id =#{good_id}")
    void updateGoodMsg(Good good);
}
