package com.mikleo.ordermodel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.mikleo.ordermodel.Dao")
public class OrdermodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdermodelApplication.class, args);
    }

}
