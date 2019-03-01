package com.ssm.chapter14.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "找不到角色信息異常")
public class RoleException extends RuntimeException{
    private static final long serialVersionUID = -1306886765792236063L;
}
