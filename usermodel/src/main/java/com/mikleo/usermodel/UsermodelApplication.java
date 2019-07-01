package com.mikleo.usermodel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.mikleo.usermodel.Feign"})
@MapperScan("com.mikleo.usermodel.Dao")
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@SpringBootApplication
public class UsermodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermodelApplication.class, args);
    }

}
