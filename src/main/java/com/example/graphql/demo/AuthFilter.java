package com.example.graphql.demo;

import com.example.graphql.demo.bean.AuthContext;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebFilter(filterName = "AuthFilter",urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void destroy() {

    }





    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 先检查session，session中没有设置AuthInfo再去调用webAPI检查登陆状态
        AuthContextHolder authContextHolder = new AuthContextHolder();
        Map<String,String[]> params = request.getParameterMap();
        String auth = StringUtils.join(params.get("auth"));
        // 设置authContext
        if (auth.equals("true")){
            authContextHolder.setContext(AuthContext.builder().role("ADMIN").username("adminUser").build());
        }else{
            authContextHolder.setContext(AuthContext.builder().role("VISITOR").username("visitorUser").build());
        }
        chain.doFilter(req,resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
