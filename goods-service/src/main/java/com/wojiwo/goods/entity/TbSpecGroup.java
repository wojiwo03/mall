package com.wojiwo.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 规格参数的分组表，每个商品分类下有多个规格参数组
 *
 * @TableName tb_spec_group
 */
@TableName(value = "tb_spec_group")
@Data
public class TbSpecGroup implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 商品分类id，一个分类下有多个规格组
     */
    private Long cid;
    /**
     * 规格组的名称
     */
    private String name;
}