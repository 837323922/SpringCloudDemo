package com.mikleo.zuul.Filter;

import com.mikleo.zuul.Model.User;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.catalina.Session;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Autowired
    RedisTemplate redisTemplate;

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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getRequestURL().toString());
        if (request.getRequestURL().toString().contains("login"))
            return false;
        else
            return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpSession session = request.getSession();
        HttpServletResponse response = requestContext.getResponse();
        System.out.println(session.getId());
        User user = (User) redisTemplate.opsForValue().get(session.getId());
        System.out.println(redisTemplate.opsForValue().get(session.getId()));
        if (null != user || null != user.getUser_id()) {
            request.getSession().setAttribute("user", user);
            redisTemplate.expire(session.getId(), 1800, TimeUnit.SECONDS);
            requestContext.setSendZuulResponse(true);
            return null;
        } else
            requestContext.setSendZuulResponse(false);
        try {
            response.sendRedirect("https://localhost:8762/loginerror");
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        log.debug("未登录,非ajax请求,返回401");
//        try {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED REQUEST");
//        } catch (IOException ex) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            log.error("run", ex);
//        }

        return null;
    }


//    private boolean isAjaxRequest(HttpServletRequest request) {
//        return (request.getHeader("accept") != null && request.getHeader("accept").contains("application/json"))
//                || (request.getHeader("X-Requested-With") != null
//                && request.getHeader("X-Requested-With").contains("XMLHttpRequest"));
//    }


    private void turnPage(HttpServletResponse response, String url) {
        try {
            response.setContentType("text/html; charset=utf-8");
            java.io.PrintWriter out = response.getWriter();
            out.println("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> ");
            out.println("<script>");
            out.println("window.open ('" + url + "','_top')");
            out.println("</script>");
            out.println("</html>");
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error("responseHTML", e);
        }
    }

}