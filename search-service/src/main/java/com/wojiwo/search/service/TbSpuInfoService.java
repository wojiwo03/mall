package com.wojiwo.search.service;

import com.wojiwo.search.entity.TbSpuInfo;
import org.springframework.data.domain.Page;

public interface TbSpuInfoService {
    void importData();

    Page<TbSpuInfo> search(String q, int current, int size);
}
