package com.wojiwo.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wojiwo.goods.entity.TbSpu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbSpuMapper extends BaseMapper<TbSpu> {
    Page<TbSpu> linkSelectPage(Page<TbSpu> page);
}




