package com.mikleo.usermodel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.mikleo.usermodel.Dao")
public class UsermodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermodelApplication.class, args);
    }

}
