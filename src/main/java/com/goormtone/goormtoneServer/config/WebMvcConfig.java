package com.goormtone.goormtoneServer.config;

import com.goormtone.goormtoneServer.interceptor.TokenAuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new TokenAuthorizationInterceptor())
            .excludePathPatterns("/css/**", "/images/**", "/js/**","/api/oauth-redirect",
                    "/swagger-ui/**","/swagger-resources/**","/v3/api-docs/**");
  }

}
