package com.mikleo.ordermodel.Model;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private int order_id;
    private int good_id;
    private  int user_id;
    private String goodname;
    private int goodnum;
    private double unitprice;
    private double totalprice;
    private Date ordertime;
    private int orderstate;
    private Date comfirmtime;
    private String fromaddress;
    private String toaddress;
    private String fromphone;
    private String tophone;
    private String fromname;
    private String toname;
}
