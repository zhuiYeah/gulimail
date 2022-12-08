package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 *  1.开启服务的注册发现
 *      配置nacos的注册中心地址
 *              application.properties
 *
 */


@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //gateway依赖common的同时依赖了他的mybatis -plus配置，但gateway暂时还没有数据库,于是排除根datasource有关的配置
public class GulimallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallGatewayApplication.class, args);
    }

}
