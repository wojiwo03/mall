package com.wojiwo.search.mapper;

import com.wojiwo.search.entity.TbSpuInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TbSpuInfoMapper extends ElasticsearchRepository<TbSpuInfo, Long> {
    long count();
    Page<TbSpuInfo> findByTitleOrSubTitle(String title, String subTitle, Pageable pageable);
}