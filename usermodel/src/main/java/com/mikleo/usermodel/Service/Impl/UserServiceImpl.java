package com.mikleo.usermodel.Service.Impl;

import com.mikleo.usermodel.Mappers.UserMapper;
import com.mikleo.usermodel.POJO.User;
import com.mikleo.usermodel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public User getUserByuserId(Integer id) {
        return userMapper.getUserByuserId(id);
    }

    @Override
    public User getUserByusername(String username) {
        return userMapper.getUserByusername(username);
    }

    @Override
    public void crearteNewUser(User user) {
        userMapper.crearteNewUser(user);
    }

    @Override
    public void changePassword(User user) {
        userMapper.changePassword(user);
    }

    @Override
    public void changeMsg(User user) {
        userMapper.changeMsg(user);
    }
}
