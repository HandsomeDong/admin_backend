package com.handsomedong.manager.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("permission")
public class Permission implements Serializable {
    private Integer id;
    private String val;
    private String name;
    private Integer type;
    private Boolean leaf;
    private Integer parent;
}
