package com.wojiwo.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wojiwo.goods.entity.TbSpecParam;
import com.wojiwo.goods.mapper.TbSpecParamMapper;
import com.wojiwo.goods.service.TbSpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class TbSpecParamServiceImpl extends ServiceImpl<TbSpecParamMapper, TbSpecParam>
        implements TbSpecParamService {

    @Autowired
    TbSpecParamMapper tbSpecParamMapper;

    @Override
    public List<TbSpecParam> myListById(List<Integer> ids) {
        return tbSpecParamMapper.selectAllInIds(ids);
    }
}




