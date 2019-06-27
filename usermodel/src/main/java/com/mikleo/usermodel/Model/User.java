package com.mikleo.usermodel.Model;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String phone;
    private Date reg_time;
    private Integer balance;
    private int role;
}
