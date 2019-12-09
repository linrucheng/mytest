import Vue from 'vue'
import Router from 'vue-router'
import Index from '../views/index/index' // 导入我们编写的vue组件

Vue.use(Router)

export default new Router({
  routes: [
    // 配置路由地址
    {
      path: '/',
      name: 'Index',
      component: Index
    }
  ]
})
