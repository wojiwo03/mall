package com.wojiwo.search.mapper;

import com.wojiwo.search.entity.TbSpuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TbSpuInfoMapper extends ElasticsearchRepository<TbSpuInfo,Long> {

}