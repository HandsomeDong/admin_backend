package com.handsomedong.manager.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.handsomedong.manager.entity.Role;

public interface RoleService extends IService<Role> {
    List<Role> getRolesByUserId(Integer id);
}
