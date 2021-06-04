package com.wojiwo.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wojiwo.goods.entity.TbSpu;

/**
 *
 */
public interface TbSpuService extends IService<TbSpu> {
    Page<TbSpu> linkSelectPage(long size, long current);
}
