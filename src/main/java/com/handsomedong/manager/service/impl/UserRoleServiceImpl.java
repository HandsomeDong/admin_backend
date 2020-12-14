package com.handsomedong.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.handsomedong.manager.mapper.UserRoleMapper;
import com.handsomedong.manager.entity.UserRole;
import com.handsomedong.manager.service.UserRoleService;

import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
