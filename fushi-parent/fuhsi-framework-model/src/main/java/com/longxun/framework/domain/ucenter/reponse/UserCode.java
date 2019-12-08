package com.longxun.framework.domain.ucenter.reponse;

import com.longxun.framework.model.response.ResultCode;
import lombok.ToString;

@ToString
public enum UserCode implements ResultCode {
    USER_ADD_EXISTSPHONE(false, 24001, "用户名已经存在!"),
    USER_LOGIN_PASSWORDERROR(false, 24002, "用户名或密码错误!"),
    USER_LOGIN_ERROR(false, 24003, "缺少请求参数!"),
    ;


    //操作代码
    boolean success;
    //操作代码l
    int code;
    //提示信息
    String message;

    private UserCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }



    @Override
    public boolean success() {
        return false;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String message() {
        return null;
    }
}
