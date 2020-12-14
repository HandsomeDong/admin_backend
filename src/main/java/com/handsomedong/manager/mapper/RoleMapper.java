package com.handsomedong.manager.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.handsomedong.manager.entity.Role;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRolesByUserId(Integer userId);
}
