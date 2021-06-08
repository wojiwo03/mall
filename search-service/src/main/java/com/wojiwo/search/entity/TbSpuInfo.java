package com.wojiwo.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "tb_spu_info")
public class TbSpuInfo {
    /**
     * spu id
     */
    @Id
    private Long id;
    /**
     * 标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;
    /**
     * 子标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String subTitle;
    /**
     * 1级类目id
     */
    private Long cid1;
    private String categoryName1;
    /**
     * 2级类目id
     */
    private Long cid2;
    private String categoryName2;
    /**
     * 3级类目id
     */
    private Long cid3;
    private String categoryName3;
    /**
     * 商品所属品牌id
     */
    private Long brandId;
    private String brandName;
    /**
     * 是否上架，0下架，1上架
     */
    private Boolean saleable;
    /**
     * 是否有效，0已删除，1有效
     */
    private Boolean valid;
    /**
     * 添加时间
     */
    private Date createTime;
    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;
}
