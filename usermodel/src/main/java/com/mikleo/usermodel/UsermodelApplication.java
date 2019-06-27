package com.mikleo.usermodel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.mikleo.usermodel.Dao")
public class UsermodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermodelApplication.class, args);
    }

}
