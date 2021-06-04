package com.wojiwo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wojiwo.auth.entity.TbRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbRoleMapper extends BaseMapper<TbRole> {
    List<TbRole> selectRFAll();
}




