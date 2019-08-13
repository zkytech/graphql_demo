package com.example.graphql.demo;

import com.oembedler.moon.graphql.boot.SchemaDirective;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfiguration {

    // 像这样添加roleDirective，如果要添加多个就创建多个类似的Bean
    @Bean
    public SchemaDirective myCustomDirective() {
        return new SchemaDirective("role", new RoleDirective());
    }


    // 模拟登录授权
    @Bean
    public FilterRegistrationBean someFilterRegistration1() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter(new AuthFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        return registration;
    }
}
