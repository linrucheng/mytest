package com.longxun.framework.model.config;

import com.longxun.framework.model.interceptor.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName XssFilterConfigurer
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/8 17:33
 * @Version V1.0
 **/
@Configuration
public class XssFilterConfigurer {
    /**
     * xss过滤拦截器
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.setOrder(Integer.MAX_VALUE-1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap();
        //excludes用于配置不需要参数过滤的请求url
        initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*");
        //isIncludeRichText主要用于设置富文本内容是否需要过滤
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }
}