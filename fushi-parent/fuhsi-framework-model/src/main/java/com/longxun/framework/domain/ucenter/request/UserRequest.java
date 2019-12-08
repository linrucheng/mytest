package com.longxun.framework.domain.ucenter.request;

import com.longxun.framework.model.request.RequestData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName UserRequest
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/7 18:53
 * @Version V1.0
 **/
@Data
@ToString
public class UserRequest extends RequestData {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("身份证号")
    private String idNumber;//身份证号

}