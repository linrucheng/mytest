package com.longxun.ucenter;

import com.longxun.framework.domain.ucenter.UserEntity;
import com.longxun.framework.domain.ucenter.reponse.UserResult;
import com.longxun.framework.domain.ucenter.request.UserRequest;
import com.longxun.ucenter.dao.UserRepository;
import com.longxun.ucenter.service.UcenterService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Test
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/8 0:01
 * @Version V1.0
 **/
@SpringBootTest(classes=UcenterManager.class)
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UcenterService ucenterService;

    @org.junit.Test
    public void addUser(){
        UserRequest request =new UserRequest();
        request.setPhone("18356024597");
        request.setIdNumber("341124199308091299");
        request.setUsername("linrucheng");
        request.setPassword("123456");
        UserResult register = ucenterService.register(request);
        System.out.println(register);
        UserResult login = ucenterService.login(request);
        System.out.println(login);

    }

  @org.junit.Test
   public void  findByIdNumber(){
      List<UserEntity> all = userRepository.findAll();

      System.out.println(all);

  }



}