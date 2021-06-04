package com.wojiwo.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 库存表，代表库存，秒杀库存等信息
 * @TableName tb_stock
 */
@TableName(value ="tb_stock")
@Data
public class TbStock implements Serializable {
    /**
     * 库存对应的商品sku id
     */
    @TableId
    private Long skuId;

    /**
     * 可秒杀库存
     */
    private Integer seckillStock;

    /**
     * 秒杀总数量
     */
    private Integer seckillTotal;

    /**
     * 库存数量
     */
    private Integer stock;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}