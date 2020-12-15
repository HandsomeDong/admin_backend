package com.handsomedong.manager.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("role")
@Data
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String code;
}
