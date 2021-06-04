package com.wojiwo.goods.controller;

import com.wojiwo.goods.service.TbSpuDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TbSpuDetailController {
    @Autowired
    private TbSpuDetailService tbSpuDetailService;
}
