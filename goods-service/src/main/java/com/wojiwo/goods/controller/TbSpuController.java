package com.wojiwo.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wojiwo.goods.entity.TbSpu;
import com.wojiwo.goods.service.TbSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TbSpuController {
    @Autowired
    private TbSpuService tbSpuService;

    @GetMapping(value = "/spus/page", params = {"size", "current"})
    public Page<TbSpu> getPage(long size, long current) {
        return tbSpuService.linkSelectPage(size, current);
    }
}
