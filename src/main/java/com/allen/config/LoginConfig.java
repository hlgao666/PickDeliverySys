package com.allen.config;

import com.allen.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Allen
 * @date 2021/6/20 10:13
 */

//@Configuration
//public class LoginConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册TestInterceptor拦截器
//        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/toLogin", "/login","login.html","/*/*.html", "/*/*.js","/*/*.css"); //所有路径都被拦截
//    }
//
//}
