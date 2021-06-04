package com.wojiwo.goods.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wojiwo.goods.entity.TbSpu;
import com.wojiwo.goods.mapper.TbSpuMapper;
import com.wojiwo.goods.service.TbSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class TbSpuServiceImpl extends ServiceImpl<TbSpuMapper, TbSpu>
        implements TbSpuService {

    @Autowired
    private TbSpuMapper tbSpuMapper;

    @Override
    public Page<TbSpu> linkSelectPage(long size, long current) {
        return tbSpuMapper.linkSelectPage(new Page<>(current, size));
    }
}




