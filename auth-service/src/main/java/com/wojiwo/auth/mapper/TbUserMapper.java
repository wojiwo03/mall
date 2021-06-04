package com.wojiwo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wojiwo.auth.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {
    TbUser selectOneByUsername(@Param("username") String username);
}




