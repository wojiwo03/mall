package com.wojiwo.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wojiwo.auth.entity.TbFunction;
import com.wojiwo.auth.mapper.TbFunctionMapper;
import com.wojiwo.auth.service.TbFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class TbFunctionServiceImpl extends ServiceImpl<TbFunctionMapper, TbFunction>
        implements TbFunctionService {
    @Autowired
    TbFunctionMapper tbFunctionMapper;

    @Override
    public List<TbFunction> listByUserId(Integer userId) {
        return tbFunctionMapper.selectAllByUserId(userId);
    }

    @Override
    public List<TbFunction> menuByUserId(Integer userId) {
        return tbFunctionMapper.selectMenuByUserId(userId);
    }
}




