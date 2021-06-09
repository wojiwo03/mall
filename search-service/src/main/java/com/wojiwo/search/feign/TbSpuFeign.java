package com.wojiwo.search.feign;

import com.wojiwo.search.entity.TbSpuInfo;
import com.wojiwo.search.util.MybatisPlusPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("goods-service")
public interface TbSpuFeign {
    @GetMapping(value = "/spus/page", params = {"size", "current"})
    MybatisPlusPage<TbSpuInfo> getPage(@RequestParam("size") Long size, @RequestParam("current") Long current);
}
