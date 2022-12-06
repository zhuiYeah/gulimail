package com.atguigu.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 1、想要远程调用别的服务
 *      1.1   在本微服务的pom.xml中引入open-feign
 *      1.2   编写一个接口（CouponFeignService），告诉SpringCloud这个接口需要调用远程服务
 *          1.2.1   声明接口的每一个方法（membercoupons）都是调用哪个远程服务（guli_coupon）的哪个请求(/coupon/coupon/member/list)
 *      1.3   开启远程调用功能 @EnableFeignClients(basePackages = "com.atguigu.gulimall.member.feign")
 * ***/

@EnableFeignClients(basePackages = "com.atguigu.gulimall.member.feign")     //开启远程调用功能
@EnableDiscoveryClient  //让配置中心nacos发现本微服务
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
