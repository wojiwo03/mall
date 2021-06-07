package com.wojiwo.search.util;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private List<T> records;
}
