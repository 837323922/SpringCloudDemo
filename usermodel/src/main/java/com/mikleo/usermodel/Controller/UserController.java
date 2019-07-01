package com.mikleo.usermodel.Controller;

import com.google.gson.Gson;
import com.mikleo.usermodel.Model.User;
import com.mikleo.usermodel.Feign.OrderService;
import com.mikleo.usermodel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private Gson gson = new Gson();

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createNewUser(@RequestBody User user) {
        user.setRole(1);
        user.setReg_time(new java.sql.Date(new Date().getTime()));
        user.setBalance(0);
        userService.crearteNewUser(user);
        return "create success!";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.getUserByuserId(id);
    }

    @RequestMapping(value = "/user/findbyname/{username}", method = RequestMethod.GET)
    public User findUserByUserName(@PathVariable("username") String username) {
        return userService.getUserByusername(username);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PATCH)
    public String changePassword(@RequestBody User user) {

        userService.changePassword(user);
        String sessionId  = RequestContextHolder.currentRequestAttributes().getSessionId();
        stringRedisTemplate.opsForValue().set(sessionId,gson.toJson(user,User.class));
        return "密码修改成功";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String setMsg(@RequestBody User user) {
        userService.changeMsg(user);
        String sessionId  = RequestContextHolder.currentRequestAttributes().getSessionId();
        stringRedisTemplate.opsForValue().set(sessionId,gson.toJson(user,User.class));
        return "信息修改成功";
    }


}
