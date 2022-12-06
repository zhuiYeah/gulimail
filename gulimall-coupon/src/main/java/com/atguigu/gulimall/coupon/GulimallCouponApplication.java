package com.atguigu.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 一 、如何使用nacos作为配置中心统一管理配置？
 *   1。在guli_common 的 pom.xml 中引入依赖
 *      <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *       </dependency>
 *
 *   2。创建一个 bootstrap.properties
 *             spring.application.name=gulimall-coupon
 *             spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 *
 *   3。需要给配置中心默认添加一个 数据集 （Data_id ） gulimall-coupon.properties
 *
 *   4. 在nacos中给gulimall-coupon.properties 添加任何本微服务需要的配置
 *
 *   5。 动态获取配置 （CouponController.java）
 *              @RefreshScope ：动态获取并刷新配置
 *              @Value("${}") ： 获取到配置
 *              如果配置中心和当前应用的配置文件中都配置了相同的项，优先使用配置中心的项目
 *
 * 二、细节
 *      1、命名空间：用于配置隔离
 *            默认命名空间：public（保留空间）；默认新增的所有配置都在public命名空间
 *            1。1 开发，测试，生产 有各自的命名空间：利用命名空间进行环境隔离
 *                 注意：在bootstrap.properties配置上，需要使用哪个命名空间下的配置
 *                     spring.cloud.nacos.config.namespace = f236a5d3-23a2-445d-99a6-cd311ea8d4ce
 *            1、2 每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
 *
 *      2、配置集
 *            所有配置的 集合
 *
 *      3、配置集id：
 *              Data_id：gulimall-coupon.properties 配置文件名
 *
 *      4、配置分组
 *              默认所有数据集都属于 DEFAULT_GROUP
 *              1111 618
 *
 *   每个微服务创建自己的命名空间，coupon,member....,使用group分分组来区分这个微服务所在的环境：dev、prod、test
 *
 *  三、 一个微服务同时加载多个配置集（拆分成多个配置文件）
 *      1.微服务的任何配置信息，配置文件都可以放在nacos配置中心中
 *
 *      2。只需要在bootstrap.properties中说明加载配置中心的哪些配置文件即可
 *
 *      3。@Value("${}") , @ConfigurationProperties....
 *            以前springboot任何方式从配置文件中获取值，都能使用。
 *            配置中心有的优先使用配置中心的
 *            当然，开发期间为了方便还是将配置写在application.yml中
 *
 *
 */



@EnableDiscoveryClient //nacos 作为注册中心，会自动注册gulimall-coupon服务
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
