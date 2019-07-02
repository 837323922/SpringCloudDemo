package com.mikleo.usermodel.Controller;

import com.google.gson.Gson;
import com.mikleo.usermodel.Model.Order;
import com.mikleo.usermodel.Model.User;
import com.mikleo.usermodel.Feign.OrderService;
import com.mikleo.usermodel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Date;
import java.util.HashMap;

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
        if (userService.crearteNewUser(user))
            return "create user success!";
        else
            return "create user fialed!";
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
        if (userService.changePassword(user)) {
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            stringRedisTemplate.opsForValue().set(sessionId, gson.toJson(user, User.class));
            return "密码修改成功";
        } else
            return "修改密码失败";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String setMsg(@RequestBody User user) {
        if (userService.changeMsg(user)) {
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            stringRedisTemplate.opsForValue().set(sessionId, gson.toJson(user, User.class));
            return "信息修改成功";
        } else
            return "信息修改成功";
    }


    @RequestMapping(value = "/user/buy", method = RequestMethod.POST)
    @Transactional
    public String buyGoods(@RequestBody Order order) {
        String reslut = userService.buyGoods(order);
        return reslut;
    }

    @RequestMapping(value = "/user/neworder", method = RequestMethod.POST)
    public String createNewOrder(@RequestBody Order order) {
        String trale = orderService.createNewOrder(order);
        System.out.println(trale);
        if (true) {
            return "create order success!";
        } else
            return "create failed!";
    }
}
