package com.example.graphql.demo;

import com.example.graphql.demo.bean.AuthContext;

/**
 * 将授权信息绑定到线程上，从而实现在该线程执行的任意位置获取授权信息
 */
public class AuthContextHolder {
    private static final ThreadLocal<AuthContext> contextHolder = new ThreadLocal<>();

    public void clearContext(){contextHolder.remove();}

    public AuthContext createEmptyContext(){return AuthContext.builder().build();}

    public AuthContext getContext(){
        AuthContext ctx = contextHolder.get();
        if (ctx == null){
            ctx = createEmptyContext();
            contextHolder.set(ctx);
        }
        return ctx;
    }

    public void setContext(AuthContext authContext){ contextHolder.set(authContext); }
}
