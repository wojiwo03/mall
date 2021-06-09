package com.wojiwo.search.service.impl;

import com.wojiwo.search.entity.TbSpuInfo;
import com.wojiwo.search.feign.TbSpuFeign;
import com.wojiwo.search.mapper.TbSpuInfoMapper;
import com.wojiwo.search.service.TbSpuInfoService;
import com.wojiwo.search.util.MybatisPlusPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbSpuInfoServiceImpl implements TbSpuInfoService {
    @Autowired
    TbSpuFeign tbSpuFeign;
    @Autowired
    TbSpuInfoMapper tbSpuInfoMapper;

    @Override
    public void importData() {
        for (long i = 1; ; i++) {
            MybatisPlusPage<TbSpuInfo> tbSpuPage = tbSpuFeign.getPage(10L, i);
            List<TbSpuInfo> tbSpuList = tbSpuPage.getRecords();
            if (tbSpuList.size() == 0) {
                break;
            }

            tbSpuList.forEach(item -> tbSpuInfoMapper.save(item));

            if (tbSpuList.size() < 10) {
                break;
            }
        }
    }

    @Override
    public Page<TbSpuInfo> search(String q, int current, int size) {
        return tbSpuInfoMapper.findByTitleOrSubTitle(q, q, PageRequest.of(current-1, size, Sort.by("id").ascending()));
    }
}
