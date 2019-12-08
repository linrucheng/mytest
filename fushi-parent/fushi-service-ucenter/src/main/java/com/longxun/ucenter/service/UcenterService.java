package com.longxun.ucenter.service;

import com.longxun.framework.domain.ucenter.UserEntity;
import com.longxun.framework.domain.ucenter.reponse.UserResult;
import com.longxun.framework.domain.ucenter.reponse.UserCode;
import com.longxun.framework.domain.ucenter.request.UserRequest;
import com.longxun.framework.model.response.CommonCode;
import com.longxun.framework.model.response.ResponseResult;
import com.longxun.framework.utils.AesUtil;
import com.longxun.framework.utils.HashUtil;
import com.longxun.framework.utils.MD5Util;
import com.longxun.ucenter.dao.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @ClassName UcenterService
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/8 0:45
 * @Version V1.0
 **/
@Service
public class UcenterService {
    @Autowired
    private UserRepository userRepository;

    public UserResult login(UserRequest loginUserRequest) {
        String username = loginUserRequest.getUsername();
        String password = loginUserRequest.getPassword();
        //缺少请求参数
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            return new UserResult(CommonCode.FAIL);
        }

        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            return new UserResult(CommonCode.FAIL);
        }

        String passwordEnCode = enCode(password);
        UserEntity byIdNumber = userRepository.findByUsernameAndPassword(username,passwordEnCode);

        if (Objects.isNull(byIdNumber)){
            return new UserResult(CommonCode.FAIL);
        }else {
            UserEntity userEntity=new UserEntity();
            userEntity.setUsername(byIdNumber.getUsername());
            userEntity.setId(byIdNumber.getId());
            return new UserResult(CommonCode.SUCCESS,userEntity);
        }


    }
    //注册,判断用户名是否存在,如果存在,则不让注册,如果
    public UserResult register(UserRequest userRequest) {
        String username = userRequest.getUsername();
        String password = userRequest.getPassword();
        String idNumber = userRequest.getIdNumber();
        String phone = userRequest.getPhone();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(idNumber) || StringUtils.isEmpty(phone)) {
            return new UserResult(CommonCode.FAIL);
        }
        UserEntity byUsername = userRepository.findByUsername(username);
        //如果存在,提示已经存在
        if (Objects.nonNull(byUsername)){
            return  new UserResult(CommonCode.FAIL);
        }
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(enCode(password));//密码加密
        //手机号身份证加密
        String sKey="1234567890123456";
        userEntity.setPhone(AesUtil.Encrypt(phone,sKey));
        userEntity.setIdNumber(AesUtil.Encrypt(idNumber,sKey));
        userEntity.setCreateTime(new Date());
        userRepository.save(userEntity);
        UserEntity user=new UserEntity();
        user.setUsername(username);
        user.setId(userEntity.getId());
       return new UserResult(CommonCode.SUCCESS,user);
    }
    private String enCode(String password) {
        //对密码进行加密
        String passwordEncodeByMd5 = MD5Util.MD5(password);//md5加密

        String salt = HashUtil.getSHA(passwordEncodeByMd5);//hash加密

        return salt;
    }



}