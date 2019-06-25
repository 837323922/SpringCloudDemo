package com.mikleo.usermodel.POJO;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer use_id;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String phone;
    private Date reg_time;
    private Integer balance;
    private int role;
}
