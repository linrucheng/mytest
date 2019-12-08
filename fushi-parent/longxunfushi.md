​    **1用户注册功能:** 根据用户名是否存在,如果存在,返回错误结果用户已经存在,如果不存在则创建用户增加到数据库,返回新用户的id和用户名方便客户端调用.

```java
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
```





  **2用户登录功能:**根据用户名和密码(加密后)判断此用户是否存在,如果存在返回结果用户id和用户名,如果不存在判断用户名和密码错误

```java
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
```

