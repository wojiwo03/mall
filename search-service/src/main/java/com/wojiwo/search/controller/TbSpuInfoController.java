package com.wojiwo.search.controller;

import com.wojiwo.search.service.TbSpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/msg")
    public String msg() {
        return "哈哈哈";
    }
}
