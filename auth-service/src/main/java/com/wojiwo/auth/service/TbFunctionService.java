package com.wojiwo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wojiwo.auth.entity.TbFunction;

import java.util.List;

/**
 *
 */
public interface TbFunctionService extends IService<TbFunction> {
    List<TbFunction> listByUserId(Integer userId);

    List<TbFunction> menuByUserId(Integer userId);
}
