package com.mikleo.ordermodel.Dao;

import com.mikleo.ordermodel.Model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    @Select("SELECT * FROM Orders WHERE order_id = #{id}")
    Order findOrderByorder_id(Integer id);

    @Select("SELECT * FROM Orders WHERE user_id=#{id}")
    List<Order> findOrdersByuser_id(int id);


    @Insert("INSERT INTO Orders VALUES(null,#{good_id},#{user_id},#{goodname},#{goodnum},#{unitprice},#{totalprice}," +
            "#{ordertime},#{orderstate},#{comfirmtime},#{fromaddress},#{toaddress},#{fromphone},#{tophone},#{fromname},#{toname})")
    void createNewOrder(Order order);

    @Delete("Delete FROM Orders WHERE order_id=#{id}")
    void deleteOrderById(int id);

    @Update("UPDATE Orders SET orderstate=#{orderstate} WHERE order_id = #{order_id}")
    void changeOrderState(Order order);

    @Update("UPDATE Orders SET goodname=#{goodname},goodnum=#{goodnum},unitprice=#{unitprice},totalprice=#{totalprice}," +
            "comfirmtime = #{comfirmtime},fromaddress=#{fromaddress},toaddress=#{toaddress},fromphone=#{fromphone}," +
            "tophone=#{tophone},fromname=#{fromname},toname=#{toname} WHERE order_id=#{order_id}")
    void updateOrderMsg(Order order);
}
