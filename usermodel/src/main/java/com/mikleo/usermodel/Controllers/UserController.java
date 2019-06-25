package com.mikleo.usermodel.Controllers;

import com.mikleo.usermodel.POJO.User;
import com.mikleo.usermodel.Service.UserService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createNewUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.crearteNewUser(user);
        return "create success!";
    }

    @RequestMapping("/find/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userService.getUserByuserId(id);
    }

    @RequestMapping("/find2/{username}")
    public User findUserById(@PathVariable("username") String username){
        return userService.getUserByusername(username);
    }

    @RequestMapping(value = "/cgpsd",method = RequestMethod.POST)
    public void changePassword(String password){
        User user = new User();
        user.setPassword(password);
        userService.changePassword(user);
    }

    @RequestMapping(value = "/setMsg",method = RequestMethod.POST)
    public void setMsg(User user){
        userService.changeMsg(user);
    }



}
