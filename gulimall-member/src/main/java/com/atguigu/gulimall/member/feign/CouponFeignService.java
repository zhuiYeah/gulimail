package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是一个声明式的远程调用
 */

@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    //membercoupons方法 会从注册中心找到微服务gulimall-coupon所在的位置
    //再去调用/coupon/coupon/member/list 请求对应的方法
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
