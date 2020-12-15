package com.handsomedong.manager.controller;

import com.handsomedong.manager.vo.Codes;
import com.handsomedong.manager.vo.Result;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一捕捉异常封装错误信息成json格式返回
 */
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ShiroException.class)
    @ResponseBody
    public Result handleShiroException(ShiroException e) {
        log.error("shiro执行出错：{}", e.getMessage());
        return new Result(false, Codes.SHIRO_ERROR, e.getMessage(), null);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseBody
    public Result result401(UnauthenticatedException e) {
        return new Result(false, Codes.UNLOGIN, e.getMessage(), null);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Result result403() {
        return new Result(false, Codes.UNAUTHZ, "该用户无访问权限", null);
    }
}
