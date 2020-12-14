package com.handsomedong.manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("permission")
public class Permission {
    private Integer id;
    private String val;
    private String name;
    private Integer type;
    private Boolean leaf;
    private Integer parent;
}
