package com.handsomedong.manager.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.handsomedong.manager.entity.Permission;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> getPermissionsByUserId(Integer userId);
}
