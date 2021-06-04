package com.wojiwo.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 规格参数组下的参数名
 *
 * @TableName tb_spec_param
 */
@TableName(value = "tb_spec_param")
@Data
public class TbSpecParam implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 商品分类id
     */
    private Long cid;
    /**
     *
     */
    private Long groupId;
    /**
     * 参数名
     */
    private String name;
    /**
     * 是否是数字类型参数，true或false
     */
    private Boolean numeric;
    /**
     * 数字类型参数的单位，非数字类型可以为空
     */
    private String unit;
    /**
     * 是否是sku通用属性，true或false
     */
    private Boolean generic;
    /**
     * 是否用于搜索过滤，true或false
     */
    private Boolean searching;
    /**
     * 数值类型参数，如果需要搜索，则添加分段间隔值，如CPU频率间隔：0.5-1.0
     */
    private String segments;
}