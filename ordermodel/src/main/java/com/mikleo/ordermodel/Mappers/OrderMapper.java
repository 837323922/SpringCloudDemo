package com.mikleo.ordermodel.Mappers;

import com.mikleo.ordermodel.POJO.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM Order WHERE order_id = #{id}")
    Order findOrderByorder_id(int id);

    @Insert("INSERT INTO Order() VALUES")
}
