package com.wojiwo.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * spu表，该表描述的是一个抽象性的商品，比如 iphone8
 *
 * @TableName tb_spu
 */
@TableName(value = "tb_spu")
@Data
public class TbSpu implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * spu id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 子标题
     */
    private String subTitle;
    /**
     * 1级类目id
     */
    private Long cid1;
    /**
     * 2级类目id
     */
    private Long cid2;
    /**
     * 3级类目id
     */
    private Long cid3;
    /**
     * 商品所属品牌id
     */
    private Long brandId;
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
    @TableField(exist = false)
    private TbCategory tbCategory1;
    @TableField(exist = false)
    private TbCategory tbCategory2;
    @TableField(exist = false)
    private TbCategory tbCategory3;
    @TableField(exist = false)
    private TbBrand tbBrand;
    @TableField(exist = false)
    private TbSpuDetail tbSpuDetail;
}