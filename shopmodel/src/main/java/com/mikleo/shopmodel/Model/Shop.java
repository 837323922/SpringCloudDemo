package com.mikleo.shopmodel.Model;

import lombok.Data;

import java.util.Date;

@Data
public class Shop {
    private int shop_id;
    private String shopname;
    private Date shopcreatedtime;
    private int accumulatepoint;
    private String shoprank;
    private String shopaddress;

}
