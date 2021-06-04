package com.wojiwo.goods.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wojiwo.goods.entity.TbSku;

/**
 * @Entity com.wojiwo.goods.entity.TbSku
 */
public interface TbSkuMapper extends BaseMapper<TbSku> {
    List<TbSku> linkSelectBySpuId(@Param("spuId") Long spuId);
}




