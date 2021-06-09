package com.wojiwo.search.util;

import lombok.Data;

import java.util.List;

@Data
public class MybatisPlusPage<T> {
    private List<T> records;
}
