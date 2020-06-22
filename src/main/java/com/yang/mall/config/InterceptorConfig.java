package com.yang.mall.config;

import com.yang.mall.interceptors.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yg
 * @date 2020/6/17 14:55
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/error", "/user/register", "/user/login", "/categories", "/products", "/products/*");
    }
}
