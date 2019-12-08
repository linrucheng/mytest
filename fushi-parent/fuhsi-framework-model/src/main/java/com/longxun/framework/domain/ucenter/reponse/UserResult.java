package com.longxun.framework.domain.ucenter.reponse;

import com.longxun.framework.domain.ucenter.UserEntity;
import com.longxun.framework.model.response.ResponseResult;
import com.longxun.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName UserResult
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/8 0:38
 * @Version V1.0
 **/
@Data
@ToString
public class UserResult extends ResponseResult implements Serializable {
    private UserEntity userEntity;

    public UserResult(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserResult(ResultCode resultCode, UserEntity userEntity) {
        super(resultCode);
        this.userEntity = userEntity;
    }

    public UserResult(ResultCode resultCode){

    }
}