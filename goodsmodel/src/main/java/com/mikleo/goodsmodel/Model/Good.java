package com.mikleo.goodsmodel.Model;

import lombok.Data;

import java.sql.Date;

@Data
public class Good {
    private int good_id;
    private int shop_id;
    private String goodname;
    private String gooddesc;
    private double goodprice;
    private int goodstock;
    private int salesvolume;
    private Date goodcreatedtime;
    private Date goodupdatetime;
}
