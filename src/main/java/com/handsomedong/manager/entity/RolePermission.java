package com.handsomedong.manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("role_permission")
public class RolePermission {
    private Integer roleId;
    private Integer permissionId;
}
