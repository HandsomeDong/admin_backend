package com.handsomedong.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.handsomedong.manager.entity.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
