package com.mikleo.ordermodel.Model;

import io.searchbox.annotations.JestId;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class Order {
    @JestId
    private int order_id;
    private int good_id;
    private  int user_id;
    private String goodname;
    private int goodnum;
    private BigDecimal unitprice;
    private BigDecimal totalprice;
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
