package com.smarttask.taskplatform.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public class SwaggerConfig {

        @Bean
        public OpenAPI openAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Smart Task Platform API")
                            .description("API documentation for Task Management System")
                            .version("1.0"));
        }
    }
}