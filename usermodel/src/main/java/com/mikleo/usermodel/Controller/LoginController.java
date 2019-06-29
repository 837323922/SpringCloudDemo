package com.mikleo.usermodel.Controller;

import com.mikleo.usermodel.Model.LoginMsg;
import com.mikleo.usermodel.Model.User;
import com.mikleo.usermodel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.concurrent.TimeUnit;

import static com.mikleo.usermodel.Service.Impl.UserServiceImpl.md5;

@RestController
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest httpRequest, @RequestBody LoginMsg loginMsg) {
        User tmp = userService.getUserByusername(loginMsg.getUsername());
        if (tmp.getPassword().equals(md5(loginMsg.getPassword()))) {
            String sessionId = httpRequest.getSession().getId();
            System.out.println(sessionId);
            redisTemplate.opsForValue().set(sessionId, tmp);
            redisTemplate.expire(sessionId,1800, TimeUnit.SECONDS);
            return "成功,将用户缓存";
        } else
            return "失败";
    }

    @RequestMapping(value = "/loginerror", method = RequestMethod.GET)
    public String loginerror() {
        return "请先登录";
    }
}
