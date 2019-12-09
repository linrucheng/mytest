<template>
  <div>
    <h1>欢迎来到后台管理系统</h1>
    用户名:
    <el-input
      placeholder="用户名"
      v-model="user.username"
      clearable>
    </el-input>
    密码:
    <el-input placeholder="密码" v-model="user.password"
              maxlength="10"  show-password></el-input>
    <el-button @click="login" >登录</el-button>
    <br><br>

  </div>
</template>
<script>
import * as ucenterApi from '../api/login'
export default {
  data () {
    return {
      user: {}
    }
  },
 methods: {
   login: function () {
     ucenterApi.login(this.user).then((res)=>{

     })
   }


 }


}
</script>
