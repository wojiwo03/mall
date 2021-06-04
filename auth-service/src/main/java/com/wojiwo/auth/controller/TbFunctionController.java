package com.wojiwo.auth.controller;

import com.wojiwo.auth.entity.TbFunction;
import com.wojiwo.auth.service.TbFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbFunctionController {
    @Autowired
    private TbFunctionService tbFunctionService;

    @GetMapping(value = "/menu", params = {"userId"})
    public List<TbFunction> getMenuByUserId(Integer userId) {
        return tbFunctionService.menuByUserId(userId);
    }
}
