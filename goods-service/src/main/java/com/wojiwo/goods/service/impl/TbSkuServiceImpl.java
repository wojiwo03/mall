package com.wojiwo.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wojiwo.goods.entity.TbSku;
import com.wojiwo.goods.mapper.TbSkuMapper;
import com.wojiwo.goods.service.TbSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class TbSkuServiceImpl extends ServiceImpl<TbSkuMapper, TbSku>
        implements TbSkuService {
    @Autowired
    TbSkuMapper tbSkuMapper;

    @Override
    public List<TbSku> linkSelectBySpuId(long spuId) {
        return tbSkuMapper.linkSelectBySpuId(spuId);
    }
}




