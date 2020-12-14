package com.handsomedong.manager.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.handsomedong.manager.mapper.RoleMapper;
import com.handsomedong.manager.entity.Role;
import com.handsomedong.manager.service.RoleService;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public List<Role> getRolesByUserId(Integer id) {
        return baseMapper.getRolesByUserId(id);
    }
}