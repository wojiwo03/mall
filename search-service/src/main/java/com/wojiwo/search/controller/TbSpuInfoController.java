package com.wojiwo.search.controller;

import com.wojiwo.search.entity.TbSpuInfo;
import com.wojiwo.search.service.TbSpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TbSpuInfoController {
    @Autowired
    TbSpuInfoService tbSpuInfoService;

    @GetMapping("/import")
    public void importData() {
        tbSpuInfoService.importData();
    }

    @GetMapping(value = "/search", params = {"q","current","size"})
    public AggregatedPageImpl<TbSpuInfo> search(String q, int current, int size) {
        return tbSpuInfoService.search(q, current, size);
    }
}
