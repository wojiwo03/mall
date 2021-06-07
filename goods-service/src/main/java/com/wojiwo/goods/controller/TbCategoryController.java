package com.wojiwo.goods.controller;

import com.wojiwo.goods.entity.TbCategory;
import com.wojiwo.goods.service.TbCategoryService;
import com.wojiwo.goods.service.impl.TbCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbCategoryController {

    @Autowired
    TbCategoryService tbCategoryService = new TbCategoryServiceImpl();

    @GetMapping("/categories")
    List<TbCategory> getList() {
        return tbCategoryService.list();
    }
}
