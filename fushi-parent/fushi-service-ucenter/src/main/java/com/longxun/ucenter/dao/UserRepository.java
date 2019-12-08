package com.longxun.ucenter.dao;

import com.longxun.framework.domain.ucenter.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,String> {

    //UserEntity findByUsername(String idNumber);

    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username,String password);
}
