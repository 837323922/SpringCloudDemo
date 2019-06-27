package com.mikleo.usermodel.Dao;

import com.mikleo.usermodel.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface UserDao {

    @Select("SELECT * FROM User WHERE user_id = #{id}")
    User getUserByuserId(Integer id);

    @Select("SELECT * FROM User WHERE username = #{username}")
    User getUserByusername(String username);

    @Insert("INSERT INTO User(username,password,reg_time,role) VALUES (#{username},#{password},#{reg_time},#{role})")
    void crearteNewUser(User user);

    @Update("UPDATE User SET password = #{password} WHERE user_id = #{user_id} and username = #{username}")
    void changePassword(User user);

    @Update("UPDATE User SET sex=#{sex},email=#{email},phone=#{phone} WHERE user_id=#{user_id} and username=#{username}")
    void changeMsg(User user);
}
