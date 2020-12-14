package com.handsomedong.manager.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.handsomedong.manager.mapper.PermissionMapper;
import com.handsomedong.manager.entity.Permission;
import com.handsomedong.manager.service.PermissionService;

import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Override
    public List<Permission> getPermissionsByUserId(Integer userId) {
        return baseMapper.getPermissionsByUserId(userId);
    }
}
