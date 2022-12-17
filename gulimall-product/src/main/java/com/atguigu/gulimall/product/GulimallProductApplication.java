package com.atguigu.gulimall.product;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、整合mybatis-plus
 *
 *      1）、导入依赖  ：在gulimall_common  pom.xml中
 *         <dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus-boot-starter</artifactId>
 *             <version>3.2.0</version>
 *         </dependency>
 *
 *       2)、配置
 *          1、配置数据源；
 *              1.1、导入数据库的驱动
 *              1.2、在application.yml中配置数据源相关信息
 *          2、配置mybatis-plus
 *              2.1、使用@MapperScan
 *              2.2、告诉mybatis-plus ,sql映射文件位置
 *
 * 2。使用mybatis的逻辑删除，，来"删除"数据库中的表项
 *     2。1配置全局的逻辑删除规则 application.yml
 *     2。2配置逻辑删除的组件Bean
 *     2。3给实体类逻辑删除字段Bean加上注解 @TableLogic
 *
 * ***/

@EnableDiscoveryClient
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
