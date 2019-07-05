package com.mikleo.usermodel.Service.Impl;

import com.mikleo.usermodel.Dao.UserDao;
import com.mikleo.usermodel.Feign.GoodService;
import com.mikleo.usermodel.Feign.OrderService;
import com.mikleo.usermodel.Feign.ShopService;
import com.mikleo.usermodel.Model.Good;
import com.mikleo.usermodel.Model.Order;
import com.mikleo.usermodel.Model.User;
import com.mikleo.usermodel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;

import static com.mikleo.usermodel.Util.StringUtils.md5;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public OrderService orderService;

    @Autowired
    public GoodService goodService;

    @Autowired
    public ShopService shopService;

    @Override
    public User getUserByuserId(Integer id) {
        return userDao.getUserByuserId(id);
    }

    @Override
    public User getUserByusername(String username) {
        return userDao.getUserByusername(username);
    }

    @Override
    public boolean crearteNewUser(User user) {
        user.setPassword(md5(user.getPassword()));
        return userDao.crearteNewUser(user);
    }

    @Override
    public boolean changePassword(User user) {
        user.setPassword(md5(user.getPassword()));
        return userDao.changePassword(user);
    }

    @Override
    public boolean changeMsg(User user) {
        return userDao.changeMsg(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String buyGoods(Order order) {
        User user = userDao.getUserByuserId(order.getUser_id());
        Good good = goodService.findGoodByGood_id(order.getGood_id());
        BigDecimal balance = user.getBalance();
        if (balance.compareTo(order.getTotalprice()) == 0)
            return "余额不足";
        user.setBalance(balance.subtract(order.getTotalprice()));
        good.setGoodstock(good.getGoodstock() - order.getGoodnum());
        good.setSalesvolume(good.getSalesvolume() + order.getGoodnum());
        goodService.updateGoodMsg(good);
        order.setComfirmtime(new Date(new java.util.Date().getTime()));
        orderService.updateOrderMsg(order);
        return "订单完成";
    }


}
