package com.longxun.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * @ClassName UcenterManager
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/7 18:59
 * @Version V1.0
 **/
@SpringBootApplication//SpringBootApplication的包扫描和ComponentScan的包扫描不能共存,
@EntityScan("com.longxun.framework.domain.ucenter") //需要扫描的实体
@ComponentScan(basePackages = {"com.longxun.api"}) //扫描的接口
@ComponentScan(basePackages = {"com.longxun.ucenter"})//扫描本项目下的所有类
@ComponentScan(basePackages = {"com.longxun.framework"})//扫描common工程下面的类
public class UcenterManager {
    public static void main(String[] args) {
        SpringApplication.run(UcenterManager.class);
    }

    @Bean
    public FilterRegistrationBean csrfFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CsrfFilter(new HttpSessionCsrfTokenRepository()));
        registration.addUrlPatterns("/*");
        return registration;
    }
}