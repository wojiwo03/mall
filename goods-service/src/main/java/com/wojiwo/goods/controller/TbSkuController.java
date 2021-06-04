package com.wojiwo.goods.controller;

import com.wojiwo.goods.entity.TbSku;
import com.wojiwo.goods.service.TbSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbSkuController {
    @Autowired
    private TbSkuService tbSkuService;

    @GetMapping(value = "/skus",params = {"spuId"})
    public List<TbSku> getSkusBySpuId(long spuId) {
        return tbSkuService.linkSelectBySpuId(spuId);
    }
}
