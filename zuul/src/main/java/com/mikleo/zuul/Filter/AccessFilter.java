package com.mikleo.zuul.Filter;

import com.google.gson.Gson;
import com.mikleo.zuul.Model.User;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(AccessFilter.class);
    private Gson gson = new Gson();

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpSession session = request.getSession();
        HttpServletResponse response = requestContext.getResponse();
        if (request.getRequestURL().toString().contains("login")) {
            requestContext.setSendZuulResponse(true);
            return null;
        }

        String json = stringRedisTemplate.opsForValue().get(session.getId());
        User user = gson.fromJson(json, User.class);
        if (null != user || null != user.getUser_id()) {
            stringRedisTemplate.expire(session.getId(), 1800, TimeUnit.SECONDS);
            requestContext.setSendZuulResponse(true);
            return null;
        } else
            requestContext.setSendZuulResponse(false);
        try {
            response.sendRedirect("https://localhost:8762/loginerror");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


//    private boolean isAjaxRequest(HttpServletRequest request) {
//        return (request.getHeader("accept") != null && request.getHeader("accept").contains("application/json"))
//                || (request.getHeader("X-Requested-With") != null
//                && request.getHeader("X-Requested-With").contains("XMLHttpRequest"));
//    }


}