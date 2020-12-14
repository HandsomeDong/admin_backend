package com.handsomedong.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.handsomedong.manager.mapper.RolePermissionMapper;
import com.handsomedong.manager.entity.RolePermission;
import com.handsomedong.manager.service.RolePermissionService;

import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
        implements RolePermissionService {
}
