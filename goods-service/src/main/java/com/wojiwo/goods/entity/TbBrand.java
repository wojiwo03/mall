package com.wojiwo.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 品牌表，一个品牌下有多个商品（spu），一对多关系
 *
 * @TableName tb_brand
 */
@TableName(value = "tb_brand")
@Data
public class TbBrand implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 品牌id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 品牌名称
     */
    private String name;
    /**
     * 品牌图片地址
     */
    private String image;
    /**
     * 品牌的首字母
     */
    private String letter;
}