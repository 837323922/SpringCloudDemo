package com.mikleo.usermodel.Controller;

import com.mikleo.usermodel.Model.LoginMsg;
import com.mikleo.usermodel.Model.User;
import com.mikleo.usermodel.Service.UserService;
import org.apache.catalina.Session;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.mikleo.usermodel.Service.Impl.UserServiceImpl.md5;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

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
        return "密码修改成功";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String setMsg(@RequestBody User user) {
        userService.changeMsg(user);
        return "信息修改成功";
    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    public String login(HttpServletRequest httpRequest, @RequestBody LoginMsg loginMsg){
        String sessionId = httpRequest.getSession().getId();
        User user = (User) redisTemplate.opsForValue().get(sessionId);
        if (user != null && user.getUsername().equals(loginMsg.getUsername()))
            return "有缓存用户";
        else {
            User tmp = userService.getUserByusername(loginMsg.getUsername());
            if (tmp.getPassword().equals(md5(loginMsg.getPassword()))){
                redisTemplate.opsForValue().set(sessionId,tmp);
                return "成功";
            }else
                return "失败";
        }
    }

}
