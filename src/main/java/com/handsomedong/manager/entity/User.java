package com.handsomedong.manager.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("user")
@Data
public class User {
    private Integer id;
    private String username;
    private String nick;
    private String pwd;
    private String salt;
    private Date created;
    private Date updated;

    @TableField(exist = false)
    private Set<Role> roles = new HashSet<>();
    @TableField(exist = false)
    private Set<Permission> permissions = new HashSet<>();
}
