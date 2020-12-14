package com.handsomedong.manager.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.handsomedong.manager.entity.Permission;

public interface PermissionService extends IService<Permission> {
    List<Permission> getPermissionsByUserId(Integer userId);
}
