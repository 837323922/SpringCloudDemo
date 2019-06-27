package com.mikleo.shopmodel.Dao;

import com.mikleo.shopmodel.Model.Shop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao {
    @Select("SELECT * FROM Shop WHERE shop_id = #{id}")
    Shop findshopByshop_id(int id);

    @Select("SELECT * FROM Shop WHERE shopname = #{shopname}")
    Shop findshopsByshop_name(String shopname);

    @Insert("INSERT INTO Shop VALUES(null,#{shopname},#{shopcreatedtime},#{accumulatepoint},#{shoprank},#{shopaddress})")
    void createNewshop(Shop shop);

    @Delete("Delete FROM Shop WHERE shop_id=#{id}")
    void deleteshopById(int id);

    @Update("UPDATE Shop SET accumulatepoint=#{accumulatepoint} WHERE shop_id = #{shop_id}")
    void changeshopstock(Shop shop);

    @Update("UPDATE Shop SET shopname=#{shopname},accumulatepoint=#{accumulatepoint},shoprank=#{shoprank},shopaddress=#{shopaddress} WHERE shop_id=#{shop_id}")
    void updateshopMsg(Shop shop);
}
