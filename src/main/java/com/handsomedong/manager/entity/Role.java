package com.handsomedong.manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("role")
@Data
public class Role {
    private Integer id;
    private String name;
    private String description;
    private String code;
}
