package com.mikleo.zuul.Model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class User implements Serializable {
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
