package com.example.springmvc2.config;

import com.example.springmvc2.interceptor.Interceptor1;
import com.example.springmvc2.interceptor.MulitiInterceptor1;
import com.example.springmvc2.interceptor.MulitiInterceptor2;
import com.example.springmvc2.interceptor.MulitiInterceptor3;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebMVCConfiguration implements WebMvcConfigurer {


 @Override
     public void addInterceptors(InterceptorRegistry registry) {
//      // 注册拦截器到Spring MVC机制，然后它会返回一个拦截器注册
//      InterceptorRegistration ir = registry.addInterceptor(new Interceptor1());
//      // 指定拦截匹配模式，限制拦截器拦截请求
//      ir.addPathPatterns("/interceptor/*");

     // 注册拦截器到Spring MVC机制中
     InterceptorRegistration ir = registry.addInterceptor(new
             MulitiInterceptor1());
     // 指定拦截匹配模式
     ir.addPathPatterns("/interceptor/*");
     // 注册拦截器到Spring MVC机制中
     InterceptorRegistration ir2 = registry.addInterceptor(new
             MulitiInterceptor2());
     // 指定拦截匹配模式
     ir2.addPathPatterns("/interceptor/*");
     // 注册拦截器到Spring MVC机制中
     InterceptorRegistration ir3 = registry.addInterceptor(new
             MulitiInterceptor3());
     // 指定拦截匹配模式
     ir3.addPathPatterns("/interceptor/*");
     }
}
