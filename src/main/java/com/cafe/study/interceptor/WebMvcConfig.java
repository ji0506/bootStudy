package com.cafe.study.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/member"); // 해당 경로는 인터셉터가 가로채지 않는다.
    }
	
    @Bean
    public KateInterceptor authInterceptor(){
    	return new KateInterceptor();
    }
}