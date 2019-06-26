package com.mikleo.usermodel.Service;

import com.mikleo.usermodel.Model.User;

public interface UserService {

    User getUserByuserId(Integer id);

    User getUserByusername(String username);

    void crearteNewUser(User user);

    void changePassword(User user);

    void changeMsg(User user);
}
