package com.wojiwo.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wojiwo.goods.entity.TbSku;

import java.util.List;

/**
 *
 */
public interface TbSkuService extends IService<TbSku> {
    List<TbSku> linkSelectBySpuId(long spuId);
}
