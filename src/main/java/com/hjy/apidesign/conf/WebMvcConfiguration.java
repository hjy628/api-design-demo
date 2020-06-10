package com.hjy.apidesign.conf;

import com.hjy.apidesign.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @auther: hjy
 * @Date: 2020/6/9 17:22
 * @Description:
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private static final String[] excludePathPatterns = {"/api/token/api_token"};

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/api/**").excludePathPatterns(excludePathPatterns);
    }
}
