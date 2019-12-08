package com.longxun.ucenter.controller;

import com.longxun.api.ucenter.UcenterControllerApi;
import com.longxun.framework.domain.ucenter.reponse.UserResult;
import com.longxun.framework.domain.ucenter.request.UserRequest;
import com.longxun.framework.model.response.ResponseResult;
import com.longxun.ucenter.service.UcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UcenterController
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/7 23:01
 * @Version V1.0
 **/
@RestController
@RequestMapping("/ucenter")
public class UcenterController implements UcenterControllerApi {
   @Autowired
   private UcenterService ucenterService;



    @Override
    @GetMapping("/test")
    public String findList(@RequestParam String id) {
        return id;
    }


    @Override
    @PostMapping("/register")
    public UserResult register(@RequestBody UserRequest loginUserRequest) {
        UserResult register = ucenterService.register(loginUserRequest);
        return register;
    }



    @Override
    @PostMapping("/login")
    public UserResult login(@RequestBody UserRequest loginUserRequest) {
        return ucenterService.login(loginUserRequest);
    }
}