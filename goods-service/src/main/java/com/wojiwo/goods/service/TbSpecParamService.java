package com.wojiwo.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wojiwo.goods.entity.TbSpecParam;

import java.util.List;

/**
 *
 */
public interface TbSpecParamService extends IService<TbSpecParam> {
    List<TbSpecParam> myListById(List<Integer> id);
}
