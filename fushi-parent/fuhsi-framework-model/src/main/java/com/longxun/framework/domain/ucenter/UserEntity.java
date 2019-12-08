package com.longxun.framework.domain.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserEntity
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/7 15:18
 * @Version V1.0
 **/

@Entity
@Data
@Table(name="user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -916357110051689486L;
    @Id //主键
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    private String username;//姓名
    private String password;//密码
    private String phone;//手机号
    private String idNumber;//身份证号
    private Date createTime;//创建时间




}