package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zhui
 * @email 850013957@qq.com
 * @date 2022-12-05 21:31:55
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
