package com.wojiwo.goods.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName tb_spu_detail
 */
@TableName(value = "tb_spu_detail")
@Data
public class TbSpuDetail implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId
    private Long spuId;
    /**
     * 商品描述信息
     */
    private String description;
    /**
     * 通用规格参数数据
     */
    private String genericSpec;
    /**
     * 特有规格参数及可选值信息，json格式
     */
    private String specialSpec;
    /**
     * 包装清单
     */
    private String packingList;
    /**
     * 售后服务
     */
    private String afterService;
}