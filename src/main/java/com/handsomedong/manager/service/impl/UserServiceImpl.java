package com.handsomedong.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.handsomedong.manager.mapper.UserMapper;
import com.handsomedong.manager.entity.User;
import com.handsomedong.manager.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
