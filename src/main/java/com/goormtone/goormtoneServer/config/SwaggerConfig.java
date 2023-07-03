package com.goormtone.goormtoneServer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "GoormTone API 명세서",
                description = "GoormTone API 명세서",
                version = "v1"
        ))
@Configuration
public class SwaggerConfig {
        /**
         * Swagger Default url "http://localhost:8080/swagger-ui/index.html"
         */
}
