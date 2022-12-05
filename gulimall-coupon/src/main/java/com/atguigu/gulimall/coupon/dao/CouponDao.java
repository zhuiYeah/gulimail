package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zhui
 * @email 850013957@qq.com
 * @date 2022-12-05 21:12:41
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
