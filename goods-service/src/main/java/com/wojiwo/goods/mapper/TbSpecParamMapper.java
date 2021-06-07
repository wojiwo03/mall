package com.wojiwo.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wojiwo.goods.entity.TbSpecParam;

import java.util.List;

/**
 * @Entity com.wojiwo.goods.entity.TbSpecParam
 */
public interface TbSpecParamMapper extends BaseMapper<TbSpecParam> {
    List<TbSpecParam> selectAllInIds(List<Integer> ids);
}




