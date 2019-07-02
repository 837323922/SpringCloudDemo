package com.mikleo.usermodel.Service;

import com.mikleo.usermodel.Model.Order;
import com.mikleo.usermodel.Model.User;

public interface UserService {

    User getUserByuserId(Integer id);

    User getUserByusername(String username);

    boolean crearteNewUser(User user);

    boolean changePassword(User user);

    boolean changeMsg(User user);

    String buyGoods(Order order);
}
