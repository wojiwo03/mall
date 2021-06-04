package com.wojiwo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wojiwo.auth.entity.TbFunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbFunctionMapper extends BaseMapper<TbFunction> {
    List<TbFunction> selectFRAll();

    List<TbFunction> selectAllByUserId(@Param("userId") Integer userId);

    List<TbFunction> selectMenuByUserId(Integer userId);
}




