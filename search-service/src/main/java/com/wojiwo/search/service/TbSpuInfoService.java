package com.wojiwo.search.service;

import com.wojiwo.search.entity.TbSpuInfo;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;

public interface TbSpuInfoService {
    void importData();

    AggregatedPageImpl<TbSpuInfo> search(String q, int current, int size);
}
