package com.mikleo.goodsmodel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mikleo.goodsmodel.Dao")
public class GoodsmodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsmodelApplication.class, args);
    }

}
