package com.wojiwo.goods.controller;

import com.wojiwo.goods.entity.TbSpecParam;
import com.wojiwo.goods.service.TbSpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbSpecParamController {
    @Autowired
    TbSpecParamService tbSpecParamService;

    @PostMapping(value = "/specParam",params = {"ids"})
    public List<TbSpecParam> getByIds(List<String> ids) {
        return tbSpecParamService.listByIds(ids);
    }
}
