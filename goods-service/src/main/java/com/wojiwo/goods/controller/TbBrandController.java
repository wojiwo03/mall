package com.wojiwo.goods.controller;

import com.wojiwo.goods.entity.TbBrand;
import com.wojiwo.goods.service.TbBrandService;
import com.wojiwo.goods.service.impl.TbBrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbBrandController {
    @Autowired
    TbBrandService tbBrandService = new TbBrandServiceImpl();

    @GetMapping("/brands")
    List<TbBrand> getList() {
        return tbBrandService.list();
    }
}
