package com.example.springmvc2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class InterNationalConfiguration {
    // 国际化拦截器
    private LocaleChangeInterceptor lci = null;

    // 国际化解析器，请注意这个Bean Name要为localeResolver
    @Bean(name = "localeResolver")
    public LocaleResolver initLocaleResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        // 默认国际化区域
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }

    // 创建国际化拦截器
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        if (lci != null) {
            return lci;
        }
        lci = new LocaleChangeInterceptor();
        // 设置参数名
        lci.setParamName("language");
        return lci;
    }

    // 给处理器增加国际化拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器在执行处理器前方法(preHandle)将请求的国际区域根据参数修改为对应的区域
        registry.addInterceptor(localeChangeInterceptor());
    }

}
