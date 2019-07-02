package com.mikleo.usermodel.Controller;

import com.google.gson.Gson;
import com.mikleo.usermodel.Model.LoginMsg;
import com.mikleo.usermodel.Model.User;
import com.mikleo.usermodel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.TimeUnit;

import static com.mikleo.usermodel.Util.StringUtils.md5;

@RestController
public class LoginController {

    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    UserService userService;


    private Gson gson= new Gson();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody LoginMsg loginMsg) {
        String sessionId  = RequestContextHolder.currentRequestAttributes().getSessionId();
        User tmp = userService.getUserByusername(loginMsg.getUsername());
        if (tmp.getPassword().equals(md5(loginMsg.getPassword()))) {
            redisTemplate.opsForValue().set(sessionId,gson.toJson(tmp));
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
