package com.wojiwo.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @TableName tb_function
 */
@TableName(value = "tb_function")
@Data
public class TbFunction implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    List<TbFunction> subFunctions;
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String url;
    /**
     *
     */
    private Integer pid;
    /**
     *
     */
    private String icon;
    /**
     *
     */
    private Integer sort;
    @TableField(exist = false)
    private List<TbRole> tbRoleList;
}