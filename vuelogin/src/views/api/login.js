import querystring from 'querystring'
import http from './../../base/api/public'
let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.longxunApiUrl


export const login = (params) => {
  return http.requestPost(apiUrl + '/ucenter/login', params)
}
