package com.handsomedong.manager.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.handsomedong.manager.entity.User;
import com.handsomedong.manager.vo.Result;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class HomeController {

    /**
     * 直接抛出异常让全局异常处理器来处理
     * @return
     */
    @RequestMapping("401")
    public Result result401() {
        throw new UnauthenticatedException("用户未登录");
    }

    @RequestMapping("403")
    public Result result403() {
        throw new UnauthenticatedException("权限不足");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(@RequestBody String body) {

        JSONObject json = JSON.parseObject(body);
        String username = json.getString("username");
        String pwd = json.getString("pwd");

        if (!StringUtils.hasText(username)) {
            return Result.failed("用户名不能为空");
        }
        if (!StringUtils.hasText(pwd)) {
            return Result.failed("密码不能为空");
        }

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, pwd));
            User user = (User) subject.getPrincipal();
            if (user == null) {
                throw new AuthenticationException();
            }
            return Result.ok("login").data("id", user.getId()).data("nick", user.getNick())
                    .data("roles", user.getRoles()).data("permissions", user.getPermissions());
        } catch (UnknownAccountException | IncorrectCredentialsException uae) {
            return Result.failed("帐号或密码不正确");
        } catch (LockedAccountException lae) {
            return Result.failed("帐号已被锁定");

        } catch (AuthenticationException ae) {
            return Result.failed("登录失败：" + ae.getMessage());
        }
    }
}
