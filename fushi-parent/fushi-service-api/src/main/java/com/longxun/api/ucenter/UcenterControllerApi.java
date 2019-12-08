package com.longxun.api.ucenter;


import com.longxun.framework.domain.ucenter.reponse.UserResult;
import com.longxun.framework.domain.ucenter.request.UserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "用户管理接口", description = "cms配置管理接口,提供数据模型的管理,查询")
public interface UcenterControllerApi {

    @ApiOperation("用户注册")
    public UserResult register(UserRequest loginUserRequest);

    public String findList(String id);

    @ApiOperation("用户登录")
    public UserResult login(UserRequest loginUserRequest);

}
