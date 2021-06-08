package com.wojiwo.search.mapper;

import com.wojiwo.search.entity.TbSpuInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TbSpuInfoMapper extends ElasticsearchRepository<TbSpuInfo, Long> {
    AggregatedPageImpl<TbSpuInfo> findTop200ByTitleOrSubTitle(String title, String subTitle, Pageable pageable);
}